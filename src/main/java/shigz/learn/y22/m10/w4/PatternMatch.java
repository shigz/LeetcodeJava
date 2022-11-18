package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/25
 */
public class PatternMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("*abcd".toCharArray(), "abcd".toCharArray()));
    }

    private static Boolean isMatch(char[] patternCharArr, char[] targetCharArr) {
        int m = patternCharArr.length;
        int n = targetCharArr.length;
        //匹配矩阵
        boolean[][] matchMatrix = new boolean[m + 1][n + 1];
        //都为空时,可以匹配
        matchMatrix[0][0] = true;
        if (patternCharArr[0] == '*') {
            //第一个字符为通配符时,可以匹配所有的有效字符
            int i = 1;
            while (i <= n && isNumOrChar(targetCharArr[i - 1])) {
                matchMatrix[0][i] = true;
                i++;
            }
            matchMatrix[1][0] = true;
            //为 * 的字符,可以匹配空字符串
            int j = 1;
            while (j < m && patternCharArr[j] == '*') {
                matchMatrix[j + 1][0] = true;
                j++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (patternCharArr[i] == '?') {
                    //匹配字符为问号,则被匹配字符为字母或数字且之前匹配结果为 true 时,匹配结果为 true
                    matchMatrix[i + 1][j + 1] = isNumOrChar(targetCharArr[j]) && matchMatrix[i][j];
                } else if (patternCharArr[i] == '*') {
                    //匹配字符为 '*', 被匹配字符为字母或数字时,若之前匹配结果为真或 * 匹配上一个字符或 * 不匹配当前字符中任意一个为true,则匹配结果为 true
                    matchMatrix[i + 1][j + 1] = isNumOrChar(targetCharArr[j]) && (matchMatrix[i][j] || matchMatrix[i + 1][j] || matchMatrix[i][j + 1]);
                } else {
                    //其他匹配字符,需要与被匹配字符相同且之前匹配结果为 true 时,匹配结果为 true
                    matchMatrix[i + 1][j + 1] = patternCharArr[i] == targetCharArr[j] && matchMatrix[i][j];
                }
            }
        }
        return matchMatrix[m][n];
    }

    private static boolean isNumOrChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

}
