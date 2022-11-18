package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/22
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (1 == nums.length) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //双指针,左右遍历
    public int firstTry(int[] nums) {
        if (1 == nums.length) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] > nums[left + 1]) return left;
            if (nums[right] > nums[right - 1]) return right;
            left++;
            right--;
        }
        return  -1;
    }

}
