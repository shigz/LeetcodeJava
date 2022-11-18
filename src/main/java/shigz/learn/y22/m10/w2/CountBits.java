package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/14
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] resultArr = new int[n + 1];
        int index = 1;
        int pre = 1;
        int max = 1;
        while (index <= n) {
            if (index < max) {
                resultArr[index] = resultArr[index - pre] + 1;
            } else {
                resultArr[index] = 1;
                pre = max;
                max = max << 1;
            }
            index++;
        }
        return resultArr;
    }

}
