package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/13
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int max = Integer.MAX_VALUE;
        int min = nums[0];
        int index = 1;
        while (index < nums.length) {
            if (nums[index] > max) {
                return true;
            } else {
                if (nums[index] < min) {
                    min = nums[index];
                } else if (nums[index] > min) {
                    max = nums[index];
                }
            };
            index++;
        }
        return false;
    }

}
