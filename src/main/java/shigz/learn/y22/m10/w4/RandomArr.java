package shigz.learn.y22.m10.w4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 大史 on 2022/11/1
 */
public class RandomArr {

    private final int[] nums;
    private final Random random;

    public RandomArr(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            indexList.add(i);
        }
        int[] resultArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(indexList.size());
            resultArr[i] = nums[indexList.get(j)];
            indexList.remove(j);
        }
        return resultArr;
    }

}
