package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/10
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[] profits = new int[prices.length];
        if (1 < prices.length) {
            if (prices[0] < prices[1]) {
                profits[1] = prices[1] - prices[0];
            }
            int index = 2;
            while (index < prices.length) {
                int tempProfit = 0;
                for (int i = 0; i < index; i++) {
                    if (prices[i] < prices[index]) {
                        int profit = prices[index] - prices[i] + (i > 1 ? profits[i - 2] : 0);
                        tempProfit = Math.max(profit, tempProfit);
                    }
                }
                profits[index] = Math.max(profits[index - 1], tempProfit);
                index++;
            }
        }
        return profits[prices.length - 1];
    }

}
