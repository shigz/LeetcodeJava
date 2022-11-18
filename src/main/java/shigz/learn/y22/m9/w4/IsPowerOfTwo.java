package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/30
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        while (n != 0) {
            if (n == 1 || n == 2) return true;
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

}
