package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/8
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0;i < nums.length;i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }

}
