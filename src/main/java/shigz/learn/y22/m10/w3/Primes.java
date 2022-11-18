package shigz.learn.y22.m10.w3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/18
 */
public class Primes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        StringBuilder sb = new StringBuilder();
        int currentPrime = 2;
        while (num != 1) {
            currentPrime = nextPrime(currentPrime,num);
            if (0 < sb.length()) {
                sb.append(" ");
            }
            sb.append(currentPrime);
            num = num / currentPrime;
        }
        System.out.println(sb);
    }

    private static int nextPrime(int fromNum, int num) {
        int max = (int) Math.sqrt(num);
        while (fromNum <= max) {
            if (num % fromNum == 0) return fromNum;
            fromNum++;
        }
        return num;
    }

}
