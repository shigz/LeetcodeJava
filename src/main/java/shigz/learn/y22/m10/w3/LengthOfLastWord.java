package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/18
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        int length = text.length();
        int index = length - 1;
        int result = length;
        while (0 <= index) {
            if (text.charAt(index) == ' ') {
                result = length - 1 - index;
                break;
            }
            index--;
        }
        System.out.println(result);
    }

}
