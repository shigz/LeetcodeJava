package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/30
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] resultArr = new int[nums.length];
        resultArr[nums.length - 1] = 1;
        resultArr[nums.length - 2] = nums[nums.length - 1];
        int index = 2;
        while (index < nums.length) {
            resultArr[nums.length - 1 - index] = nums[nums.length - index] * resultArr[nums.length - index];
            index++;
        }
        int current = 1;
        index = 0;
        while (index < resultArr.length) {
            resultArr[index] *= current;
            current *= nums[index];
            index++;
        }

        return resultArr;
    }

}
