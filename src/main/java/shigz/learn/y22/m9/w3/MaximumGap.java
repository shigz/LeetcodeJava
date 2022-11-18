package shigz.learn.y22.m9.w3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 大史 on 2022/9/22
 */
public class MaximumGap {

    public int maximumGap(int[] nums) {
        int result = sortFrom(nums, 0, nums.length - 1);
        return result;
    }

    private int sortFrom(int[] nums, int left, int right) {
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();
        int result = 0;
        if (left != right) {
            int mid = (left + right) / 2;
            sortFrom(nums, left, mid);
            for (int i = left; i <= mid; i++) {
                leftQueue.add(nums[i]);
            }
            sortFrom(nums, mid + 1, right);
            for (int i = mid + 1; i <= right; i++) {
                rightQueue.add(nums[i]);
            }
            int i = left;
            while (i <= right) {
                if (0 < leftQueue.size()) {
                    if (0 < rightQueue.size()) {
                        nums[i] = leftQueue.peek() < rightQueue.peek() ? leftQueue.poll() : rightQueue.poll();
                    } else {
                        nums[i] = leftQueue.poll();
                    }
                } else {
                    nums[i] = rightQueue.poll();
                }
                if (i != left) {
                    result = Math.max(result,nums[i]- nums[i - 1]);
                }
                i++;
            }
        }
        return result;
    }

}
