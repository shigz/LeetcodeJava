package shigz.learn.y22.m9.w3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 大史 on 2022/9/19
 */
public class FindLadders {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<>();
        List<Integer> nearIndexListArr[] = new List[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            List<Integer> distanceArr = new ArrayList<>();
            if (isNear(wordList.get(i), beginWord)) {
                distanceArr.add(i);
            }
            for (int j = 0; j < i; j++) {
                if (isNear(wordList.get(j), wordList.get(i))) {
                    distanceArr.add(j);
                    nearIndexListArr[j].add(i);
                }
            }
            nearIndexListArr[i] = distanceArr;
        }
        List<Integer> indexList = new ArrayList<>();
        int endWordIndex = wordList.indexOf(endWord);
        if (0 < endWordIndex) {
            indexList.add(endWordIndex);
            List<Integer[]> result = listResult(endWordIndex, nearIndexListArr, indexList);
            for (Integer[] indexArr : result) {
                List<String> finalWordList = new ArrayList<>();
                finalWordList.add(beginWord);
                for (int k = indexArr.length - 1; k >= 0; k--) {
                    finalWordList.add(wordList.get(indexArr[k]));
                }
                resultList.add(finalWordList);
            }
        }
        return resultList;
    }

    private List<Integer[]> listResult(int currentIndex, List<Integer>[] nearIndexListArr, List<Integer> indexList) {
        List<Integer[]> resultList = new ArrayList<>();
        List<Integer> nearIndexList = nearIndexListArr[currentIndex];
        if (nearIndexList.contains(currentIndex)) {
            resultList.add(indexList.toArray(new Integer[indexList.size()]));
        } else {
            for (Integer nearByIndex : nearIndexList) {
                if (!indexList.contains(nearByIndex)) {
                    indexList.add(nearByIndex);
                    resultList.addAll(listResult(nearByIndex, nearIndexListArr, indexList));
                    indexList.remove(indexList.size() - 1);
                }
            }
        }
        if (1 < resultList.size()) {
            int minLength = resultList.stream().map(list -> list.length).min(Comparator.comparing(Integer::valueOf)).get();
            return resultList.stream().filter(list -> list.length == minLength).collect(Collectors.toList());
        } else return resultList;

    }

    private boolean isNear(String word, String oWord) {
        int count = 0;
        int index = 0;
        while (index < word.length()) {
            if (word.charAt(index) != oWord.charAt(index)) {
                count++;
            }
            index++;
        }
        return count == 1;
    }

}
