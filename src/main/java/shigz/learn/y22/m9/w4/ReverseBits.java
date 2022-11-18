package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/26
 */
public class ReverseBits {

    public int reverseBits(long n) {
        return n >= 0 ? (int) reverse(n) : (int)-reverse(-n);
    }

    private long reverse(long n) {
        int[] bits = new int[32];
        long remain = n;
        int index = 0;
        while (remain != 0) {
            if (remain % 2 == 1) bits[index] = 1;
            index++;
            remain = remain >> 1;
        }
        long result = bits[0];
        index = 1;
        while (index < 32) {
            result = (result << 1) + bits[index];
            index++;
        }
        return result;
    }

}
