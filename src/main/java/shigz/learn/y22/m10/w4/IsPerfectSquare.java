package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/31
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 1;
        long right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long temp = mid * mid;
            if (temp == num){
                return true;
            } else if (temp > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
