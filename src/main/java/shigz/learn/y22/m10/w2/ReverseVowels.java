package shigz.learn.y22.m10.w2;

import shigz.common.BaseObject;

/**
 * Created by 大史 on 2022/10/14
 */
public class ReverseVowels extends BaseObject {

    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int left = getVowelIndexFrom(s, 0);
        int right = getVowelIndexBefore(s, charArr.length - 1);
        while (0 <= left && 0 <= right && left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left = getVowelIndexFrom(s, left + 1);
            right = getVowelIndexBefore(s, right - 1);
        }
        return new String(charArr);
    }

    private boolean isVowels(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    private int getVowelIndexFrom(String s, int startIndex) {
        if (startIndex < s.length()) {
            if (isVowels(s.charAt(startIndex))) {
                return startIndex;
            } else return getVowelIndexFrom(s, startIndex + 1);
        } else return -1;
    }

    private int getVowelIndexBefore(String s, int endIndex) {
        if (endIndex >= 0) {
            if (isVowels(s.charAt(endIndex))) {
                return endIndex;
            } else return getVowelIndexBefore(s, endIndex - 1);
        } else return -1;
    }

}
