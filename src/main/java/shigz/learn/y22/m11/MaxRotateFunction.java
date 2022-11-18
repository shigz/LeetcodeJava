package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/2
 */
public class MaxRotateFunction {

    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int dp = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp += i * nums[i];
        }
        int res = dp;
        for (int i = 1; i < n; i++) {
            dp = sum + dp - n  * nums[n - i];
            res = Math.max(dp, res);
        }
        return res;
    }

}
