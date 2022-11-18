package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/23
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int result = 0;
        while (n != 0) {
            n /= 5;
            result += n;
        }
        return result;
    }


}
