package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/29
 */
public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int i = 1;
        while (i < nums.length) {
            int j = Math.max(i - indexDiff, 0);
            while (j < i) {
                if (nums[i] >= 0) {
                    if (nums[j] >= nums[i]) {
                        if (nums[j] - nums[i] <= valueDiff) {
                            return true;
                        }
                    } else {
                        if (nums[i] - valueDiff <= nums[j]) {
                            return true;
                        }
                    }
                } else {
                    if (nums[j] >= nums[i]) {
                        if (nums[i] + valueDiff >= nums[j]) {
                            return true;
                        }
                    } else {
                        if (nums[j] + valueDiff >= nums[i]) {
                            return true;
                        }
                    }
                }
                j++;
            }
            i++;
        }
        return false;
    }

}
