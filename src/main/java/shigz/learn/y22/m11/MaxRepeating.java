package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/3
 */
public class MaxRepeating {

    public int maxRepeating(String sequence, String word) {
        int result = 0;
        char[] charArr = sequence.toCharArray();
        char[] subCharArr = word.toCharArray();
        int[] dp = new int[charArr.length + 1];
        int index = subCharArr.length - 1;
        while (index < charArr.length) {
            if (isEqualBefore(charArr, subCharArr, index, subCharArr.length - 1)) {
                dp[index + 1] = dp[index + 1 - subCharArr.length] + 1;
                result = Math.max(result, dp[index + 1]);
            } else {
                dp[index + 1] = 0;
            }
            index++;
        }
        return result;
    }

    private boolean isEqualBefore(char[] charArr, char[] subCharArr, int endIndex, int subEndIndex) {
        if (endIndex >= 0) {
            if (subEndIndex >= 0) {
                if (charArr[endIndex] == subCharArr[subEndIndex]) {
                    return isEqualBefore(charArr, subCharArr, endIndex - 1, subEndIndex - 1);
                } else return false;
            } else return true;
        } else {
            return subEndIndex < 0;
        }
    }

}
