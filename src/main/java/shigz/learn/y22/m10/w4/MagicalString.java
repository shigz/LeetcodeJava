package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/31
 */
public class MagicalString {

    public int magicalString(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int i = 0;
        int j = 0;
        int flag = 1;
        int res = 0;
        while (i < n + 1 && j < n + 1) {
            if (dp[i] == 1) {
                dp[j] = flag;
                j++;
                flag = flag == 1 ? 2 : 1;
                res += 1;
            } else {
                dp[j] = flag;
                dp[j + 1] = flag;
                flag = flag == 1 ? 2 : 1;
                j += 2;
            }
            i++;
        }
        return res;
    }


}
