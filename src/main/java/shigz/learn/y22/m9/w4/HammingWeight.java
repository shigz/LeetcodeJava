package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/26
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        return getWeight(n >= 0 ? -n : n);
    }

    private int getWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == -1) count++;
            n /= 2;
        }
        return count;
    }

}
