package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/21
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1;i < nums.length;i++) {
            result = result ^ nums[i];
        }
        return result;
    }

}
