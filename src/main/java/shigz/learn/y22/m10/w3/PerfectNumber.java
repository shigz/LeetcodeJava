package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class PerfectNumber {

    public static void main(String[] args) {
        for (int i = 0; i < 5000000; i++) {
            if (isPerfect(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPerfect(int num) {
        if (num == 0) return true;
        int sum = 1;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i < sqrt; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        if (sqrt * sqrt == num) sum += sqrt;
        return sum == num;
    }

    private static int countPerfect(int num) {
        if (num < 28) return 1;
        if (num < 498) return 2;
        if (num < 8128) return 3;
        return 4;
    }

}
