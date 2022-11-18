package shigz.learn.y22.m9.w3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by 大史 on 2022/9/20
 */
public class MinCut {

    public int secondTry(String s) {
        Map<Integer, HashSet<Integer>> minIndexMap = new HashMap<>();
        int index = 0;
        while (index < s.length() - 1) {
            int currentMin = minOf(s, index, minIndexMap);
            HashSet<Integer> indexSet = minIndexMap.containsKey(currentMin) ? minIndexMap.get(currentMin) : new HashSet<>();
            indexSet.add(index);
            minIndexMap.put(currentMin, indexSet);
            index++;
        }
        return minOf(s, s.length() - 1, minIndexMap);
    }

    private int minOf(String s, int index, Map<Integer, HashSet<Integer>> minIndexMap) {
        if (isPalindrome(s, 0, index)) return 0;
        int currentMin = 0;
        while (currentMin < index) {
            if (minIndexMap.containsKey(currentMin)) {
                HashSet<Integer> indexSet = minIndexMap.get(currentMin);
                for (Integer currentIndex : indexSet) {
                    if (isPalindrome(s, currentIndex + 1, index)) {
                        return currentMin + 1;
                    }
                }
            }
            currentMin++;
        }
        return index;
    }

    public int minCut(String s) {
        int[] minArr = new int[s.length()];
        int index = 0;
        while (index < s.length()) {
            if (isPalindrome(s, 0, index)) {
                minArr[index] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                int startIndex = 1;
                while (startIndex < index) {
                    if (isPalindrome(s, startIndex, index) && minArr[startIndex - 1] + 1 < min) {
                        min = minArr[startIndex - 1] + 1;
                    }
                    startIndex++;
                }
                if (minArr[index - 1] + 1 < min) {
                    min = minArr[index - 1] + 1;
                }
                minArr[index] = min;
            }
            index++;
        }
        return minArr[s.length() - 1];
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}
