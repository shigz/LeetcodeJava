package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/28
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        for (int i = (k - 2) / 2; i >= 0; i--) {
            heapify(nums, i, k);
        }
        for (int j = k; j < nums.length; j++) {
            if (nums[0] >= nums[j]) continue;
            nums[0] = nums[j];
            heapify(nums, 0, k);
        }
        return nums[0];
    }

    private void heapify(int[] nums, int i, int size) {
        int left = i * 2 + 1;
        while (left < size) {
            int small = left + 1 < size && nums[left] > nums[left + 1] ? left + 1 : left;
            if (nums[i] <= nums[small]) {
                break;
            }
            swap(nums, i, small);
            i = small;
            left = i * 2 + 1;
        }
    }

    public void swap(int[] nums, int a, int b) {
        //本题中调用swap时已经确定a!=b，因此不用判断
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }

}
