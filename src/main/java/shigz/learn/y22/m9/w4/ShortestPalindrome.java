package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/28
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int longestPalindromeIndex = getLongestPalindromeIndex(s);
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(longestPalindromeIndex + 1)).reverse().append(s);
        return sb.toString();
    }

    private int getLongestPalindromeIndex(String s) {
        int index = s.length() - 1;
        while (index > 0) {
            if (isPalindromeBeforeIndex(s, index)) return index;
            index--;
        }
        return 0;
    }

    private boolean isPalindromeBeforeIndex(String s, int index) {
        int left = 0;
        int right = index;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

}
