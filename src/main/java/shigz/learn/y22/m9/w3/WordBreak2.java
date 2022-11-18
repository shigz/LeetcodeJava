package shigz.learn.y22.m9.w3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> resultList = new ArrayList<>();
        List<List<Integer>>[] resultArr = new ArrayList[s.length()];
        int index = 0;
        while (index < s.length()) {
            List<List<Integer>> currentResultList = new ArrayList<>();
            for (int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                int startIndex = index + 1 - word.length();
                if (startIndex == 0) {
                    if (isEqualsFrom(s, word, startIndex)) {
                        List<Integer> indexList = Collections.singletonList(i);
                        currentResultList.add(indexList);
                    }
                } else if (0 < startIndex) {
                    if (isEqualsFrom(s, word, startIndex)) {
                        for (List<Integer> preResultList : resultArr[startIndex - 1]) {
                            List<Integer> indexList = new ArrayList<>(preResultList);
                            indexList.add(i);
                            currentResultList.add(indexList);
                        }
                    }
                }
            }
            resultArr[index] = currentResultList;
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Integer> preResultList : resultArr[resultArr.length - 1]) {
            sb.append(wordDict.get(preResultList.get(0)));
            for (int i = 1;i < preResultList.size();i++) {
                sb.append(" ").append(wordDict.get(preResultList.get(i)));
            }
            resultList.add(sb.toString());
            sb.delete(0,sb.length());
        }
        return resultList;
    }

    private boolean isEqualsFrom(String s, String word, int index) {
        int j = 0;
        while (j < word.length()) {
            if (s.charAt(index + j) != word.charAt(j)) return false;
            j++;
        }
        return true;
    }

}
