package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/11/1
 */
public class RandomizedCollection {

    private final List<Integer> numList;
    private final Map<Integer,PriorityQueue<Integer>> numIndexMap;
    private final Random random;

    public RandomizedCollection() {
        numList = new ArrayList<>();
        numIndexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        numList.add(val);
        if (numIndexMap.containsKey(val)) {
            numIndexMap.get(val).add(numList.size() - 1);
            return false;
        } else {
            PriorityQueue<Integer> indexQueue = new PriorityQueue<>(Comparator.reverseOrder());
            indexQueue.add(numList.size() - 1);
            numIndexMap.put(val,indexQueue);
            return true;
        }

    }

    public boolean remove(int val) {
        if (!numIndexMap.containsKey(val)) return false;
        PriorityQueue<Integer> indexQueue = numIndexMap.get(val);
        Integer index = indexQueue.poll();
        int lastIndex = numList.size() - 1;
        if (index != lastIndex) {
            Integer lastNum = numList.get(lastIndex);
            numList.set(index, lastNum);
            PriorityQueue<Integer> lastNumQueue = numIndexMap.get(lastNum);
            lastNumQueue.poll();
            lastNumQueue.offer(index);
        }
        numList.remove(numList.size() - 1);
        if (0 == indexQueue.size()) numIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(numList.size());
        return numList.get(index);
    }

}
