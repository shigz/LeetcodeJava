package shigz.learn.y22.m9.w4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 大史 on 2022/9/30
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] resultArr = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k && nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                resultArr[i - k + 1] = deque.peekFirst();
            }

        }
        return resultArr;
    }

}
