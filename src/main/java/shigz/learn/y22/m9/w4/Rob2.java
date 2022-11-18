package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/28
 */
public class Rob2 {

    public int rob(int[] nums) {
        if (1 == nums.length) return nums[0];
        int result = 0;
        int[] containsArr = new int[nums.length];
        int[] notContainsArr = new int[nums.length];
        containsArr[0] = nums[0];
        containsArr[1] = nums[0];
        result = Math.max(result, nums[0]);
        notContainsArr[1] = nums[1];
        result = Math.max(result, nums[1]);
        if (nums.length > 2) {
            for (int k = 2; k < nums.length - 1; k++) {
                int containsMax = Math.max(containsArr[k - 2] + nums[k], containsArr[k - 1]);
                result = Math.max(containsMax, result);
                containsArr[k] = containsMax;
                int notContainsMax = Math.max(notContainsArr[k - 2] + nums[k], notContainsArr[k - 1]);
                result = Math.max(notContainsMax, result);
                notContainsArr[k] = notContainsMax;
            }
            int lastMax = Math.max(notContainsArr[nums.length - 3] + nums[nums.length - 1], notContainsArr[nums.length - 2]);
            result = Math.max(lastMax, result);
        }
        return result;
    }

}
