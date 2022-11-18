package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/14
 */
public class IsPowerOfFour {

    public boolean isPowerOfFour(int n) {
        int k = 1;
        while (k > 0 && k < n) {
            k = k << 2;
        }
        return n == k;
    }

}
