package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/19
 */
public class IsPasswordValid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            System.out.println(isValid(in.nextLine())?"OK":"NG");
        }
    }

    private static boolean isValid(String password) {
        if (password.length() < 8) return false;
        int[] haveTypeArr = new int[4];
        char[] charArr = password.toCharArray();
        for (int i = 0;i < password.length();i++) {
            char c = charArr[i];
            if (c >= '0' && c <= '9') {
                haveTypeArr[0] = 1;
            } else if (c >= 'A' && c <= 'Z') {
                haveTypeArr[1] = 1;
            } else if (c >= 'a' && c <= 'z') {
                haveTypeArr[2] = 1;
            } else {
                haveTypeArr[3] = 1;
            }
            if (i >= 6) {
                for (int j = 3; j <= i - 3;j++) {
                    if (charArr[j - 2] == charArr[i - 2] && charArr[j - 1] == charArr[i - 1] && charArr[j] == charArr[i]) {
                        return false;
                    }
                }
            }
        }
        int count = 0;
        for (int haveType:haveTypeArr) {
            if (haveType == 0) count++;
        }
        return count <= 1;
    }

}
