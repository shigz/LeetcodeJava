package shigz.learn.y22.m10.w2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/9
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] maxArr = new int[nums.length];
        int max = 1;
        int currentMax;
        for (int i = 0; i < nums.length; i++) {
            currentMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    currentMax = Math.max(maxArr[j] + 1, currentMax);
                }
            }
            maxArr[i] = currentMax;
            max = Math.max(currentMax,max);
        }
        return max;
    }

    //Map 记录下所有路径的最大值,速度慢,并且内存消耗高
    public int secondTry(int[] nums) {
        Map<Integer, Map<Integer, Integer>> resultMap = new HashMap<>();
        int max = 1;
        int min = nums[0];
        resultMap.put(nums[0], new HashMap<>());
        resultMap.get(nums[0]).put(nums[0], 1);
        int index = 1;
        while (index < nums.length) {
            if (nums[index] < min) {
                resultMap.put(nums[index], new HashMap<>());
                resultMap.get(nums[index]).put(nums[index], 1);
                min = nums[index];
            } else {
                for (Map.Entry<Integer, Map<Integer, Integer>> outEntry : resultMap.entrySet()) {
                    if (outEntry.getKey() < nums[index]) {
                        int subMax = 0;
                        for (Map.Entry<Integer, Integer> innerEntry : outEntry.getValue().entrySet()) {
                            if (innerEntry.getKey() < nums[index]) {
                                subMax = Math.max(subMax, innerEntry.getValue() + 1);
                            }
                        }
                        if (!outEntry.getValue().containsKey(nums[index]) || outEntry.getValue().get(nums[index]) < subMax) {
                            max = Math.max(max, subMax);
                            outEntry.getValue().put(nums[index], subMax);
                        }
                    }
                }
            }
            index++;
        }
        return max;
    }


    //暴力递归,超时
    public int firstTry(int[] nums) {
        return lengthOfList(nums, 0, Integer.MIN_VALUE, 0);
    }

    private int lengthOfList(int[] nums, int currentIndex, int max, int currentCount) {
        if (currentIndex < nums.length) {
            if (nums[currentIndex] > max) {
                return Math.max(lengthOfList(nums, currentIndex + 1, max, currentCount), lengthOfList(nums, currentIndex + 1, nums[currentIndex], currentCount + 1));
            } else {
                return lengthOfList(nums, currentIndex + 1, max, currentCount);
            }
        } else return currentCount;
    }

}
