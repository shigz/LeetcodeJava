package shigz.learn.y22.m10.w3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/17
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int num : nums1) {
            numCountMap.put(num, 1 + numCountMap.getOrDefault(num, 0));
        }
        for (int num : nums2) {
            int count = numCountMap.getOrDefault(num, 0);
            if (0 < count) {
                resultList.add(num);
                numCountMap.put(num, count - 1);
            }
        }

        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

}
