package shigz.learn.y22.m9.w3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/9/19
 */
public class LongestConsecutive {

    public int firstTry(int[] nums) {
        int result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                int leftCount = countMap.getOrDefault(num - 1, 0);
                int rightCount = countMap.getOrDefault(num + 1, 0);
                int totalCount = leftCount + 1 + rightCount;
                countMap.put(num, totalCount);
                if (totalCount > result) {
                    result = totalCount;
                }
                countMap.put(num - leftCount, totalCount);
                countMap.put(num + rightCount, totalCount);
            }
        }
        return result;
    }

}
