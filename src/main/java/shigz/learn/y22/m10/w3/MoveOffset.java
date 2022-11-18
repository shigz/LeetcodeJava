package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/19
 */
public class MoveOffset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(";");
        int x = 0;
        int y = 0;
        for (String str : strArr) {
            if (str.length() == 3 || str.length() == 2) {
                switch (str.charAt(0)) {
                    case 'A':
                        x -= getDistance(str);
                        break;
                    case 'D':
                        x += getDistance(str);
                        break;
                    case 'S':
                        y -= getDistance(str);
                        break;
                    case 'W':
                        y += getDistance(str);
                        break;
                    default:
                }
            }
        }
        System.out.print(x);
        System.out.print(",");
        System.out.println(y);
    }

    private static int getDistance(String str) {
        int result = 0;
        int index = 1;
        while (index < str.length()) {
            int current = str.charAt(index) - '0';
            if (current >= 0 && current <= 9) {
                result = result * 10 + current;
            } else return 0;
            index++;
        }
        return result;
    }
}
