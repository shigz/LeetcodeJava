package shigz.learn.y22.m10.w4;

import java.util.Arrays;

/**
 * Created by 大史 on 2022/11/1
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1;i <= target;i++) {
            //遍历数据,如果当前数字减掉数字有次数,则结果进行累计
            for (int num:nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
