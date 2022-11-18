package shigz.learn.y22.m10.w2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 大史 on 2022/10/8
 */
public class SingleNumber {

    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> resultList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            resultList.add(nums[0]);
        }
        for (int i = 1; i < nums.length - 1;i ++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                resultList.add(nums[i]);
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            resultList.add(nums[nums.length - 1]);
        }
        int[] resultArr = new int[2];
        for (int i = 0; i < 2; i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

}
