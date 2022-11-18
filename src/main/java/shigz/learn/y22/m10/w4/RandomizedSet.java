package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/11/1
 */
public class RandomizedSet {

    private final List<Integer> numList;
    private final Map<Integer, Integer> numIndexMap;
    private final Random random;

    public RandomizedSet() {
        numList = new ArrayList<>();
        numIndexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (numIndexMap.containsKey(val)) {
            return false;
        } else {
            numList.add(val);
            numIndexMap.put(val, numList.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (numIndexMap.containsKey(val)) {
            Integer index = numIndexMap.get(val);
            int lastIndex = numList.size() - 1;
            if (index != lastIndex) {
                Integer lastNum = numList.get(lastIndex);
                numList.set(index, lastNum);
                numIndexMap.put(lastNum, index);
            }
            numList.remove(lastIndex);
            numIndexMap.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return numList.get(random.nextInt(numList.size()));
    }

}
