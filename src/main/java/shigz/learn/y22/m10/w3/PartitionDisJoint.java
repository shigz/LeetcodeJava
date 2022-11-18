package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class PartitionDisJoint {

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minRightArr = new int[n];
        minRightArr[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRightArr[i] = Math.min(minRightArr[i + 1], nums[i]);
        }
        int maxLeft = 0;
        for (int i = 0; i < n - 1; i++) {
            maxLeft = Math.max(nums[i],maxLeft);
            if (maxLeft <= minRightArr[i + 1]) return i + 1;
        }
        return n;
    }

}
