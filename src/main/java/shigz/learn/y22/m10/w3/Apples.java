package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class Apples {

    public static void main(String[] args) {
        System.out.println(maxCount(7, 3));
    }

    private static int maxCount(int m, int n) {
        int[][] dp = new int[m][n];
        return maxCount(dp, m, n);
    }

    private static int maxCount(int[][] dp, int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (m == 1|| n == 1 || m == 0) return 1;
        if (dp[m - 1][n - 1] != 0) return dp[m - 1][n - 1];
        dp[m - 1][n - 1] = maxCount(dp, m, n - 1) + maxCount(dp, m - n, n);
        return  dp[m - 1][n - 1];
    }

}
