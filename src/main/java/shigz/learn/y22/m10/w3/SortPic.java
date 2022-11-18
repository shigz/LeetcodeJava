package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/20
 */
public class SortPic {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] charArr = in.nextLine().toCharArray();
        sort(charArr);
        System.out.println(charArr);
    }

    private static void sort(char[] charArr) {
        for (int i = 1; i < charArr.length; i++) {
            int j = i;
            char cur = charArr[i];
            int preJ = i - 1;
            while (preJ >= 0 && charArr[preJ] > cur) {
                charArr[j] = charArr[preJ];
                j = preJ;
                preJ--;
            }
            if (j != i) charArr[j] = cur;
        }
    }

}
