package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/27
 */
public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int left, int right) {
        int result = left;
        while (left < right) {
            result = result & (left + 1);
            if (result == 0) return 0;
            left++;
        }
        return result;
    }

}
