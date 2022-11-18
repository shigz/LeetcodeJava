package shigz.learn.y22.m9.w3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/9/23
 */
public class MajorityElement {

    //使用 nums 作为存储空间记录当前元素个数，非当前元素个数超过当前元素总个数时,换下一个元素,若某个元素个数超过 1 / 2,则最终应该是它
    public int majorityElement(int[] nums) {
        int count = 1;
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count != 0 && x == nums[i]) {
                count++;
            } else if (count != 0 && x != nums[i]) {
                count--;
            } else {
                x = nums[i];
                count = 1;
            }
        }
        return x;
    }

    //HashMap 缓存每个元素次数，空间负责度高
    public int firstTry(int[] nums) {
        int result = 0;
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int index = 0;
        while (index < nums.length) {
            int currentCount = countMap.containsKey(nums[index]) ? countMap.get(nums[index]) + 1 : 1;
            if (count < currentCount) {
                result = nums[index];
                count = currentCount;
            }
            countMap.put(nums[index], currentCount);
            index++;
        }
        return result;
    }

}
