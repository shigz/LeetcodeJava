package shigz.learn.y22.m10.w4;

import java.util.PriorityQueue;

/**
 * Created by 大史 on 2022/11/1
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1,num2) -> num2 - num1);
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (queue.size() < k) {
                    queue.offer(ints[j]);
                } else {
                    if (ints[j] < queue.peek()) {
                        queue.poll();
                        queue.offer(ints[j]);
                    } else {
                        if (j == 0) return queue.poll();
                        break;
                    }
                }
            }
        }
        return queue.poll();
    }

}
