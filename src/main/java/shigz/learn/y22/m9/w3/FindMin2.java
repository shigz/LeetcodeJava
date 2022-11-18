package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/22
 */
public class FindMin2 {

    public int findMin(int[] nums) {
        return findMin(nums,0,nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            int mid = (left + right) / 2;
            if (mid == left) return nums[right];
            if (nums[mid] > nums[left]) {
                return findMin(nums, mid + 1, right);
            } else if (nums[mid] == nums[left]) {
                return Math.min(findMin(nums, left, mid - 1), findMin(nums, mid, right));
            } else {
                return findMin(nums, left, mid);
            }
        }
        return nums[left];
    }

}
