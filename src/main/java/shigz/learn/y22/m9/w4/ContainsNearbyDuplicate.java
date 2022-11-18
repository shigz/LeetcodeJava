package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/29
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int index = 1;
        while (index < nums.length) {
            int j = index - k;
            if (j < 0) j = 0;
            while (j < index) {
                if (nums[index] == nums[j]) return true;
                j++;
            }
            index++;
        }
        return false;
    }

}
