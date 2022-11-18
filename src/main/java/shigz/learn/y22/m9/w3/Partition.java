package shigz.learn.y22.m9.w3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/20
 */
public class Partition {

    public List<List<String>> partition(String s) {
        return partitionTo(s, s.length() - 1);
    }

    private List<List<String>> partitionTo(String s, int index) {
        List<List<String>> resultList = new ArrayList<>();
        int startIndex = index;
        while (0 < startIndex) {
            String subText = s.substring(startIndex, index + 1);
            if (isPalindrome(s, startIndex, index)) {
                List<List<String>> leftPartition = partitionTo(s, startIndex - 1);
                for (List<String> leftList : leftPartition) {
                    leftList.add(subText);
                }
                resultList.addAll(leftPartition);
            }
            startIndex--;
        }
        if (isPalindrome(s,0,index)) {
            List<String> textList = new ArrayList<>();
            textList.add(s.substring(0, index + 1));
            resultList.add(textList);
        }
        return resultList;
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
