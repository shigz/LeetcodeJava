package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/12
 */
public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        int k = 1;
        while (k > 0 && k < n) {
            k *= 3;
        }
        return k == n;
    }

}
