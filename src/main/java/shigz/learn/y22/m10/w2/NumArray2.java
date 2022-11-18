package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/10
 */
public class NumArray2 {
    int[] nums;
    int[] sums;

    public NumArray2(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        int sub = val - nums[index];
        for (int i = index + 1;i < sums.length;i++) {
            sums[i] = sums[i] + sub;
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }

}
