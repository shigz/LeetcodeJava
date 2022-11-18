package shigz.learn.y22.m10.w2;

import java.util.*;

/**
 * Created by 大史 on 2022/10/11
 */
public class MaxProduct {

    public int maxProduct(String[] words) {
        int result = 0;
        Map<Integer, Integer> maskLengthMap = new HashMap<>();
        for (String word : words) {
            int mask = getMask(word);
            if (!maskLengthMap.containsKey(mask) || maskLengthMap.get(mask) < word.length())
                maskLengthMap.put(mask, word.length());
        }
        int n = maskLengthMap.size();
        Integer[] arr = maskLengthMap.keySet().toArray(new Integer[n]);
        for (int i = 0; i < n; i++) {
            for (int j = 0;j < i;j++) {
                if ((arr[i] & arr[j]) == 0) result = Math.max(result,maskLengthMap.get(arr[i]) * maskLengthMap.get(arr[j]));
            }
        }
        return result;
    }


    //位运算 还可以进一步优化
    public int secondTry(String[] words) {
        int n = words.length;
        int[] maskArr = new int[n];
        for (int i = 0; i < n; i++) {
            maskArr[i] = getMask(words[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((maskArr[i] & maskArr[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    private int getMask(String word) {
        int res = 0;
        for (char c : word.toCharArray()) {
            res |= 1 << (c - 'a');
        }
        return res;
    }

    //暴力穷举,比较慢
    public int firstTry(String[] words) {
        int result = 0;

        List<Set<Integer>> indexSetList = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            indexSetList.add(new HashSet<>());
        }
        boolean[] usedArr;
        usedArr = new boolean[26];
        for (char c : words[0].toCharArray()) {
            int charIndex = c - 'a';
            if (!usedArr[charIndex]) {
                indexSetList.get(charIndex).add(0);
                usedArr[charIndex] = true;
            }
        }
        int i = 1;
        int[] countArr;
        while (i < words.length) {
            usedArr = new boolean[26];
            countArr = new int[i];
            for (char c : words[i].toCharArray()) {
                int charIndex = c - 'a';
                if (!usedArr[charIndex]) {
                    Set<Integer> preIndexSet = indexSetList.get(charIndex);
                    for (Integer preIndex : preIndexSet) {
                        countArr[preIndex]--;
                    }
                    preIndexSet.add(i);
                    usedArr[charIndex] = true;
                }
            }
            for (int k = 0; k < countArr.length; k++) {
                if (countArr[k] == 0) {
                    result = Math.max(result, words[i].length() * words[k].length());
                }
            }
            i++;
        }
        return result;
    }

}
