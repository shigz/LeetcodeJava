package shigz.learn.y22.m10.w2;

import shigz.common.BaseObject;

/**
 * Created by 大史 on 2022/10/14
 */
public class IntegerBreak extends BaseObject {

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] resultArr = new int[n + 1];
        resultArr[2] = 2;
        resultArr[3] = 3;
        int index = 4;
        while (index <= n) {
            int end = index - 2;
            int max = 0;
            while (end >= index / 2) {
                max = Math.max(resultArr[end] * resultArr[index - end],max);
                end--;
            }
            resultArr[index] = max;
            index++;
        }
        return resultArr[n];
    }

}
