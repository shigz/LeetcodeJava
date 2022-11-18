package shigz.learn.y22.m10.w2;

import shigz.common.ListNode;

import java.util.Arrays;

/**
 * Created by 大史 on 2022/10/10
 */
public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        long[][] mulIndexArr = new long[primes.length][2];
        long[] resultArr = new long[n];
        resultArr[0] = 1;
        for (int i = 0; i < primes.length; i++) {
            mulIndexArr[i] = new long[]{primes[i], 0};
        }
        for (int i = 1; i < n; i++) {
            long temp = Integer.MAX_VALUE;
            for (int j = 0; j < mulIndexArr.length; j++) {
                while (mulIndexArr[j][0] <= resultArr[i - 1]) {
                    mulIndexArr[j] = new long[]{resultArr[(int) (mulIndexArr[j][1] + 1)] * primes[j], mulIndexArr[j][1] + 1};
                }
                temp = Math.min(temp, mulIndexArr[j][0]);
            }
            resultArr[i] = temp;
        }
        return (int) resultArr[n - 1];
    }

    //暴力遍历 超出时间限制
    public int firstTry(int n, int[] primes) {
        long[] resultArr = new long[n];
        Arrays.fill(resultArr, Integer.MAX_VALUE);
        resultArr[0] = 1;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && primes[primes.length - 1] * resultArr[j] > resultArr[i - 1]) {
                long temp = primes[primes.length - 1] * resultArr[j];
                int k = primes.length - 2;
                while (k >= 0 && primes[k] * resultArr[j] > resultArr[i - 1]) {
                    temp = primes[k] * resultArr[j];
                    k--;
                }
                resultArr[i] = Math.min(resultArr[i], temp);
                j--;
            }
        }
        return (int) resultArr[n - 1];
    }

}
