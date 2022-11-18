package shigz.learn.y22.m11;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 大史 on 2022/11/8
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num:nums) {
            if (!queue.contains(num)) {
                if (queue.size() < 3) {
                    queue.add(num);
                } else {
                    if (queue.peek() < num) {
                        queue.poll();
                        queue.add(num);
                    }
                }

            }
        }
        if (3 == queue.size()) return queue.poll();
        while (1 < queue.size()) {
            queue.poll();
        }
        return queue.poll();
    }

}
