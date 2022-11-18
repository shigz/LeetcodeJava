package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/21
 */
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int result = 0;
        int b = 0;
        for (int num : nums) {
            b = (b ^ num) & ~result;
            result = (result ^ num) & ~b;
        }
        return b;
    }

}
