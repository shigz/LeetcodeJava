package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/21
 */
public class Distance {

    public static void main(String[] args) {
        System.out.println(min("zikwvkijajpkaicihcffiemzexmwjjlyrylxcuoewdmpivudhmgkuodjaurazdjnlgtpwz".toCharArray(), "wpnmubqfsnmapqpufmmsphqehjplwjkqspnnpywsvvjilxbcfsrygbelquaalenvkruyltiwqcpdrxgstywaja".toCharArray()));
    }

    private static int min(char[] charArr1, char[] charArr2) {
        int m = charArr1.length;
        int n = charArr2.length;
        int[][] dp = new int[2][n + 1];
        for (int i = 1;i <= n;i++) {
            dp[1][i] = i;
        }
        for (int i = 1;i <= m;i++) {
            dp[0][0] = dp[1][0];
            dp[1][0] = i;
            for (int j = 1;j <= n;j++) {
                dp[0][j] = dp[1][j];
                if (charArr1[i - 1] == charArr2[j - 1]) {
                    dp[1][j] = dp[0][j - 1];
                } else {
                    dp[1][j] = Math.min(dp[0][j - 1],Math.min(dp[0][j],dp[1][j - 1]) ) + 1;
                }
            }
        }
        return dp[1][n];
    }

    private static int minLength(char[] charArr1, char[] charArr2) {
        int m = charArr1.length;
        int n = charArr2.length;
        int[][] distanceMatrix = new int[m][n];
        if (charArr1[0] != charArr2[0]) distanceMatrix[0][0] = 1;
        for (int i = 1; i < m; i++) {
            distanceMatrix[i][0] = charArr1[i] == charArr2[0] ? distanceMatrix[i - 1][0] : distanceMatrix[i - 1][0] + 1;
        }
        for (int i = 1; i < n; i++) {
            distanceMatrix[0][i] = charArr1[0] == charArr2[i] ? distanceMatrix[0][i - 1] : distanceMatrix[0][i - 1] + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (charArr1[i] == charArr2[j]) {
                    distanceMatrix[i][j] = distanceMatrix[i - 1][j - 1];
                } else {
                    distanceMatrix[i][j] = Math.min(distanceMatrix[i - 1][j - 1] + 1, Math.min(distanceMatrix[i - 1][j] + 1, distanceMatrix[i][j - 1] + 1));
                }

            }
        }
        return distanceMatrix[m - 1][n - 1];
    }

}
