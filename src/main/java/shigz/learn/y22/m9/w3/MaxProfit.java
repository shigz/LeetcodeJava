package shigz.learn.y22.m9.w3;

import shigz.common.BaseObject;

/**
 * Created by 大史 on 2022/9/8
 */
public class MaxProfit extends BaseObject {

    public int firstTry(int[] prices) {
        int singleMax = 0;
        int result = 0;
        int secondMax = Integer.MIN_VALUE;
        int minPrice = prices[0];
        int index = 1;
        while (index < prices.length) {
            if (prices[index] + secondMax > result) {
                result = prices[index] + secondMax;
            }
            if (prices[index] - minPrice > singleMax) {
                singleMax = prices[index] - minPrice;
                if (prices[index] - minPrice > result) {
                    result = prices[index] - minPrice;
                }
            } else {
                if (prices[index] < minPrice) {
                    minPrice = prices[index];
                }
            }
            if (singleMax - prices[index] > secondMax) {
                secondMax = singleMax - prices[index];
            }
            index += 1;

        }
        return result;
    }

}
