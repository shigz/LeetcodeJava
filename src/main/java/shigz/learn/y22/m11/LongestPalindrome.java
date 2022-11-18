package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/4
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int[] charCountArr = new int[52];
        int result = 0;
        for (char c : charArr) {
            int index = (c >= 'A' && c <= 'Z')?c - 'A' + 26:c - 'a';
            if (charCountArr[index] == 0) {
                charCountArr[index] = 1;
            } else {
                result += 1;
                charCountArr[index] = 0;
            }
        }

        result <<= 1;
        if (result < s.length()) result++;
        return result;
    }

}
