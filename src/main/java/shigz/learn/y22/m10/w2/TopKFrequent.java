package shigz.learn.y22.m10.w2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 大史 on 2022/10/14
 */
public class TopKFrequent {

    //小根堆
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numCountMap = new ConcurrentHashMap<>();
        for (int num:nums) {
            numCountMap.put(num, 1 + numCountMap.getOrDefault(num,0));
        }
        PriorityQueue<Integer> numQueue = new PriorityQueue<>(k, Comparator.comparingInt(numCountMap::get));
        for (Map.Entry<Integer,Integer> entry:numCountMap.entrySet()) {
            if (numQueue.size() < k) {
                numQueue.offer(entry.getKey());
            } else if (entry.getValue() > numCountMap.get(numQueue.peek())) {
                numQueue.poll();
                numQueue.offer(entry.getKey());
            }
        }
        int[] resultArr = new int[k];
        int i = 0;
        while (0 < numQueue.size()) {
            resultArr[i] = numQueue.poll();
            i++;
        }
        return resultArr;
    }

    public int[] firstTry(int[] nums, int k) {
        Map<Integer,Integer> numCountMap = new ConcurrentHashMap<>();
        for (int num:nums) {
            numCountMap.put(num, 1 + numCountMap.getOrDefault(num,0));
        }
        while (k < numCountMap.size()) {
            for (Map.Entry<Integer,Integer> entry:numCountMap.entrySet()) {
                if (entry.getValue() == 1) {
                    numCountMap.remove(entry.getKey());
                } else {
                    numCountMap.put(entry.getKey(),entry.getValue() - 1);
                }
            }
        }
        int[] resultArr = new int[numCountMap.size()];
        Iterator<Integer> keyIt = numCountMap.keySet().iterator();
        int i = 0;
        while (keyIt.hasNext()) {
            resultArr[i] = keyIt.next();
            i++;
        }
        return resultArr;
    }

}
