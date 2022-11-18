package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/9
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zeroStartIndex = -1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                if (zeroStartIndex < 0) {
                    zeroStartIndex = index;
                }
            } else {
                if (zeroStartIndex >= 0) {
                    nums[zeroStartIndex] = nums[index];
                    zeroStartIndex += 1;
                    nums[index] = 0;
                }
            }
            index++;
        }
    }

}
