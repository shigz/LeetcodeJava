package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/28
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = 0;
            while (j < i) {
                if (nums[i] == nums[j]) return true;
                j++;
            }
            i++;
        }
        return false;
    }

}
