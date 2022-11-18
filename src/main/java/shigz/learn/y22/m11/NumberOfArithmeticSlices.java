package shigz.learn.y22.m11;

import java.util.Arrays;

/**
 * Created by 大史 on 2022/11/8
 */
public class NumberOfArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int startIndex = 0;
        while (startIndex < nums.length - 2) {
            for (int i = startIndex + 1; i < nums.length - 1; i++) {
                result += numberOfArithmeticSlices(nums, nums[i] - nums[startIndex], i, i + 1);
            }
            startIndex++;
        }
        return result;
    }

    private int numberOfArithmeticSlices(int[] nums, int differ, int fromIndex, int currentIndex) {
        if (currentIndex < nums.length) {
            int newDiffer = nums[currentIndex] - nums[fromIndex];
            if (newDiffer < differ) {
                return numberOfArithmeticSlices(nums, differ, fromIndex, currentIndex + 1);
            } else if (newDiffer == differ) {
                return 1 + numberOfArithmeticSlices(nums, differ, currentIndex, currentIndex + 1);
            } else {
                return 0;
            }
        } else return 0;
    }

}
