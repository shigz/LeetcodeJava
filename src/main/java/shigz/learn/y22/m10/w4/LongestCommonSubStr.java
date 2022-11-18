package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/25
 */
public class LongestCommonSubStr {

    public static void main(String[] args) {
        String shortStr = "abcdefghijklmnop";
        String longStr = "abcsafjklmnopqrstuvw";
        System.out.println(textLongestSubStr(shortStr.toCharArray(),longStr.toCharArray()));
    }

    private static String textLongestSubStr(char[] shortCharArr, char[] longCharArr) {
        int m = shortCharArr.length;
        int n = longCharArr.length;
        int maxLength = 0;
        int maxLengthIndex = 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, getMaxEqualLength(shortCharArr, longCharArr, i, j));
            }
            if (maxLength < max) {
                maxLength = max;
                maxLengthIndex = i;
            }
        }
        return new String(shortCharArr, maxLengthIndex, maxLength);
    }

    private static int getMaxEqualLength(char[] shortCharArr, char[] longCharArr, int startX, int startY) {
        if (startX < shortCharArr.length && startY < longCharArr.length && shortCharArr[startX] == longCharArr[startY]) {
            return 1 + getMaxEqualLength(shortCharArr, longCharArr, startX + 1, startY + 1);
        } else return 0;
    }

}
