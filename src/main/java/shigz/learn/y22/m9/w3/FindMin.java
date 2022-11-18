package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/22
 */
public class FindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] <= nums[right]) return nums[left];
            int mid = (left + right) / 2;
            if (mid == left) return nums[right];
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
