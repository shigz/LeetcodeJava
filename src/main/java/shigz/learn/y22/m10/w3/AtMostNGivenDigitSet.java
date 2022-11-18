package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/18
 */
public class AtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] countArr = arrCount(digits);
        int result = countArr[n % 10];
        n = n / 10;
        int mul = digits.length;
        int total = mul;
        while (n > 0) {
            if (n % 10 > 0) {
                if (countArr[n % 10] > 0) {
                    result += countArr[n % 10] * total;
                } else {
                    result = total;
                }
            }
            mul *= digits.length;
            total += mul;
            n /= 10;
        }
        return result;
    }

    private int[] arrCount(String[] digits) {
        int[] countArr = new int[10];
        int count = 0;
        int startIndex = 1;
        for (String digit : digits) {
            int num = digit.charAt(0) - '0';
            for (int i = startIndex; i < num; i++) {
                countArr[i] = count;
            }
            startIndex = num;
            count++;
        }
        for (int i = startIndex; i < 10; i++) {
            countArr[i] = count;
        }
        return countArr;
    }

}
