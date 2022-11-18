package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/18
 */
public class CharCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int targetC = in.nextLine().charAt(0);
        if (targetC >= 'A' && targetC <= 'Z') {
            targetC = targetC - 'A' + 'a';
        }
        int result = 0;
        for (int c:str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = c - 'A' + 'a';
            }
            if (c == targetC) result++;
        }
        System.out.println(result);
    }

}
