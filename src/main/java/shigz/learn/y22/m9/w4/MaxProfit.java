package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/26
 */
public class MaxProfit {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][][] dp = new int[prices.length][2][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[0][1][i] = -prices[0];
        }
        for (int i = 1;i < prices.length;i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            for (int j = 1;j <= k;j++) {
                dp[i][1][j] = Math.max(dp[i - 1][1][j],dp[i - 1][0][j - 1] - prices[i]);
                dp[i][0][j] = Math.max(dp[i - 1][0][j],dp[i - 1][1][j] + prices[i]);
            }
        }
        int max = 0;
        for (int i = 0;i <= k;i++) {
            max = Math.max(max,dp[prices.length - 1][0][i]);
        }
        return max;
    }

}
