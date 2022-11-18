package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/22
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int result = nums[0];
        int[] minArr = new int[nums.length];
        minArr[0] = result;
        int index = 1;
        while (index < nums.length) {
            int maxMul = nums[index] * nums[index - 1];
            int minMul = nums[index] * minArr[index - 1];
            int min = Math.min(nums[index], Math.min(minMul,maxMul));
            int max = Math.max(nums[index], Math.max(minMul,maxMul));
            result = Math.max(max,result);
            nums[index] = max;
            minArr[index] = min;
            index++;
        }
        return result;
    }

}
