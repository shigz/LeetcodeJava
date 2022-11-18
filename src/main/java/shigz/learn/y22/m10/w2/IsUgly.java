package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/8
 */
public class IsUgly {

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else return false;
        }
        return true;
    }

}
