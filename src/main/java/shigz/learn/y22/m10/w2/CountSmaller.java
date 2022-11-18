package shigz.learn.y22.m10.w2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 大史 on 2022/10/11
 */
public class CountSmaller {

    private static int N = 20001;
    private static int B = 10001;
    private static int[] tree = new int[N + 1];

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums) {
            update(B + num, 1);
        }
        for (int num : nums) {
            update(B + num, -1);
            resultList.add(query(B + num - 1));
        }
        return resultList;
    }

    private void update(int num, int v) {
        while (num <= N) {
            tree[num] += v;
            num += lowBit(num);
        }
    }

    private int query(int num) {
        int result = 0;
        while (num > 0) {
            result += tree[num];
            num -= lowBit(num);
        }
        return result;
    }

    private int lowBit(int num) {
        return num & (-num);
    }

    //二分排序,通过,但效率一般
    public List<Integer> secondTry(int[] nums) {
        List<Integer> sortedList = new ArrayList<>();
        Integer[] resArr = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0;
            int right = sortedList.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sortedList.get(mid) >= nums[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            resArr[i] = left;
            sortedList.add(left, nums[i]);
        }
        return Arrays.asList(resArr);
    }

    //暴力穷举,超时
    public List<Integer> firstTry(int[] nums) {
        Integer[] resArr = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int smallerCount = 0;
            int minMax = 0;
            int maxMax = 0;
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] == nums[j]) {
                    minMax = smallerCount + resArr[j];
                    break;
                } else if (nums[i] < nums[j]) {
                    maxMax = Math.max(maxMax, smallerCount + resArr[j]);
                    if (maxMax == minMax) break;
                } else {
                    smallerCount += 1;
                    minMax = Math.max(minMax, smallerCount + resArr[j]);
                    if (maxMax == minMax) break;
                }
                j++;
            }
            resArr[i] = minMax;
        }

        return Arrays.asList(resArr);
    }

}
