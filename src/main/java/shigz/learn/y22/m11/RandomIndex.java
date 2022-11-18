package shigz.learn.y22.m11;

import java.util.*;

/**
 * Created by 大史 on 2022/11/2
 */
public class RandomIndex {

    private final Map<Integer, List<Integer>> indexListMap;
    private final Random random;

    public RandomIndex(int[] nums) {
        indexListMap = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (indexListMap.containsKey(nums[i])) {
                indexListMap.get(nums[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                indexListMap.put(nums[i], indexList);
            }
        }
    }

    public int pick(int target) {
        if (indexListMap.containsKey(target)) {
            return indexListMap.get(target).get(random.nextInt(indexListMap.get(target).size()));
        } else return -1;
    }

}
