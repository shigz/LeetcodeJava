package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/20
 */
public class Crypt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        System.out.println(enCrypt(in.nextLine().toCharArray()));
        System.out.println(deCrypt(in.nextLine().toCharArray()));
    }

    private static char[] enCrypt(char[] charArr) {
        for (int i = 0;i < charArr.length;i ++) {
            char c = charArr[i];
            if (c >= 'a' && c <= 'z') {
                charArr[i] = (char) ((c - 'a' + 1) % 26 + 'A');
            } else  if (c >= 'A' && c <= 'Z') {
                charArr[i] = (char) ((c - 'A' + 1) % 26 + 'a');
            } else {
                charArr[i] = (char) ((c - '0' + 1) % 10 + '0');
            }
        }
        return charArr;
    }

    private static char[] deCrypt(char[] charArr) {
        for (int i = 0;i < charArr.length;i ++) {
            char c = charArr[i];
            if (c >= 'a' && c <= 'z') {
                charArr[i] = (char) ((c - 'a' + 25) % 26 + 'A');
            } else  if (c >= 'A' && c <= 'Z') {
                charArr[i] = (char) ((c - 'A' + 25) % 26 + 'a');
            } else {
                charArr[i] = (char) ((c - '0' + 9) % 10 + '0');
            }
        }
        return charArr;
    }

}
