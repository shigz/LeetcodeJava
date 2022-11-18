package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/8
 */
public class AddDigits {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        } else {
            int result = 0;
            while (num >= 10) {
                result += num % 10;
                num /= 10;
            }
            result += num;
            return addDigits(result);
        }
    }

}
