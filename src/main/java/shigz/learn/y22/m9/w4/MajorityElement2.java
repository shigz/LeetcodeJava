package shigz.learn.y22.m9.w4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/30
 */
public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        int[][] resultArr = new int[2][2];

        for (int num : nums) {
            if (resultArr[0][1] == 0) {
                if (resultArr[1][1] == 0) {
                    resultArr[0][0] = num;
                    resultArr[0][1] = 1;
                } else {
                    if (resultArr[1][0] == num) {
                        resultArr[1][1] += 1;
                    } else {
                        resultArr[0][0] = num;
                        resultArr[0][1] = 1;
                    }
                }
            } else {
                if (resultArr[1][1] == 0) {
                    if (resultArr[0][0] == num) {
                        resultArr[0][1] += 1;
                    } else {
                        resultArr[1][0] = num;
                        resultArr[1][1] = 1;
                    }
                } else {
                    if (resultArr[0][0] == num) {
                        resultArr[0][1] += 1;
                    } else {
                        if (resultArr[1][0] == num) {
                            resultArr[1][1] += 1;
                        } else {
                            resultArr[0][1] -= 1;
                            resultArr[1][1] -= 1;
                        }
                    }
                }
            }
        }

        resultArr[0][1] = 0;
        resultArr[1][1] = 0;
        for (int num : nums) {
            if (num == resultArr[0][0]) resultArr[0][1] += 1;
            if (num == resultArr[1][0]) resultArr[1][1] += 1;
        }
        List<Integer> resultList = new ArrayList<>();
        for (int[] result : resultArr) {
            if (result[1] > nums.length / 3) {
                if (!resultList.contains(result[0])) {
                    resultList.add(result[0]);
                }
            }
        }
        return resultList;
    }

}
