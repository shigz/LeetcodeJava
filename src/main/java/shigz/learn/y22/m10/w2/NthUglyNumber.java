package shigz.learn.y22.m10.w2;

import shigz.common.BaseObject;

/**
 * Created by 大史 on 2022/10/8
 */
public class NthUglyNumber extends BaseObject {

    public int nthUglyNumber(int n) {
        int[] numArr = new int[n];
        numArr[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int index = 1;
        while (index < n) {
            numArr[index] = Math.min(Math.min(numArr[index2] * 2, numArr[index3] * 3), numArr[index5] * 5);
            if (numArr[index] == numArr[index2] * 2) {
                index2++;
            }
            if (numArr[index] == numArr[index3] * 3) {
                index3++;
            }
            if (numArr[index] == numArr[index5] * 5) {
                index5++;
            }
            index++;
        }
        return numArr[n - 1];
    }

}
