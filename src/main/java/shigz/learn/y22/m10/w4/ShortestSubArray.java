package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/10/26
 */
public class ShortestSubArray {

    public int shortestSubArray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        //计算前缀和
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            //计算最小长度 如果值大于目标值,更新长度到结果
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            //移除队列中大于等于当前前缀和的坐标,因为若它们的值大于目标值,则 当前坐标的值更大于目标值,且长度更短
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            //当前坐标值加入到队列中
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }

}
