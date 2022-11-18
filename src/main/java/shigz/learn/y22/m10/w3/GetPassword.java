package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/20
 */
public class GetPassword {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] charArr = in.nextLine().toCharArray();

        int mid = charArr.length / 2;
        int max = getPassword(charArr,mid);
        for (int i = 0; i < mid; i++) {
            if (2 * (mid - i) + 1 <= max) {
                break;
            }
            max = Math.max(max,getPassword(charArr,mid - i));
            max = Math.max(max,getPassword(charArr,mid + i));
        }
        System.out.println(max);
    }

    private static int getPassword(char[] charArr, int index) {
        int sum1 = 1;
        while (sum1 <= index && index + sum1 < charArr.length && charArr[index - sum1] == charArr[index + sum1]) {
            sum1++;
        }
        int sum2 = 0;
        while (sum2 <= index - 1 && index + sum2 < charArr.length && charArr[index - 1 - sum2] == charArr[index + sum2]) {
            sum2++;
        }
        return Math.max(2 * sum1 - 1,2 * sum2);
    }

}
