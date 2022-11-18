package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/26
 */
public class Rob {

    public int rob(int[] nums) {
        if (1 < nums.length) {
            if (nums[1] < nums[0]) nums[1] = nums[0];
            int index = 2;
            while (index < nums.length) {
                nums[index] = Math.max(nums[index - 1],nums[index] + nums[index - 2]);
                index ++;
            }
        }
        return nums[nums.length - 1];
    }

}
