package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/2
 */
public class IntegerReplacement {


    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement(n - 1),integerReplacement(n + 1)) + 1;
        }
    }

}
