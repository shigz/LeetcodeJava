package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/27
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int result = 0;
        int i = 0;
        while (i < n) {
            if (isPrime(i)) {
                result++;
            }
            i++;
        }
        return result;
    }


    private boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        // 只有6x-1和6x+1的数才有可能是质数
        if (n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        // 判断这些数能否被小于sqrt(n)的奇数整除
        int sqrt = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrt; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
