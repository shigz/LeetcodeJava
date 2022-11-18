package shigz.learn.y22.m11;

import shigz.common.BaseObject;

/**
 * Created by 大史 on 2022/11/2
 */
public class FindNthDigit extends BaseObject {

    public int findNthDigit(int n) {
        int count = 1;
        long mul = 9;
        long num = 0;
        while (n > mul * count) {
            num += mul;
            n -= mul * count;
            mul = mul * 10;
            count++;
        }
        long finalNum = num + (n - 1) / count + 1;
        int index = ((n % count) + count - 1) % count;
        return String.valueOf(finalNum).charAt(index) - '0';
    }

}
