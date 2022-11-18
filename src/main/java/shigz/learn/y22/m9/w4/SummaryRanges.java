package shigz.learn.y22.m9.w4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/30
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        int left = 0;
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] + 1 != nums[index + 1]) {
                if (left == index) {
                    resultList.add(String.valueOf(nums[index]));
                } else {
                    resultList.add(nums[left] + "->" + nums[index]);
                }
                left = index + 1;
            }
            index++;
        }
        if (left == nums.length - 1) {
            resultList.add(String.valueOf(nums[nums.length - 1]));
        } else if (left < nums.length - 1) {
            resultList.add(nums[left] + "->" + nums[nums.length - 1]);
        }
        return resultList;
    }

}
