package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/19
 */
public class PasswordTransfer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] passwords = in.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c:passwords) {
            if (c == 'Z') {
                c = 'a';
            }  else if (c >= 'A' && c < 'Z') {
                c = (char) (c - 'A' + 'b');
            } else if (c >= 'a' && c <= 'c') {
                c = '2';
            } else if (c >= 'd' && c <= 'f') {
                c = '3';
            } else if (c >= 'g' && c <= 'i') {
                c = '4';
            } else if (c >= 'j' && c <= 'l') {
                c = '5';
            } else if (c >= 'm' && c <= 'o') {
                c = '6';
            } else if (c >= 'p' && c <= 's') {
                c = '7';
            } else if (c >= 't' && c <= 'v') {
                c = '8';
            } else if (c >= 'w' && c <= 'z') {
                c = '9';
            }
            sb.append(c);
        }
        System.out.println(sb);
    }

}
