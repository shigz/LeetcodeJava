package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/11
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] minCountArr = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i == coin) min = 1;
                if (i > coin && minCountArr[i - coin] < Integer.MAX_VALUE) {
                    min = Math.min(min, minCountArr[i - coin] + 1);
                }
            }
            minCountArr[i] = min;
        }
        return minCountArr[amount] < Integer.MAX_VALUE ? minCountArr[amount] : -1;
    }

}
