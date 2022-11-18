package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/27
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int current = 0;
        while (current < nums.length) {
            if (nums[current] >= target) return 1;
            sum += nums[current];
            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[left];
                    left += 1;
                }
                result = Math.min(current - left + 2, result);
            }
            current++;
        }
        return result > nums.length ? 0 : result;
    }

}
