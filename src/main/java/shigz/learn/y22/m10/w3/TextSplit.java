package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/18
 */
public class TextSplit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String text = in.nextLine();
            if (0 < text.length()) {
                int startIndex = 0;
                while (startIndex + 8 <= text.length()) {
                    System.out.println(text.substring(startIndex, startIndex + 8));
                    startIndex += 8;
                }
                if (startIndex < text.length()) {
                    sb.append(text.substring(startIndex));
                    int length = sb.length();
                    for (int i = 0; i < 8 - length; i++) {
                        sb.append('0');
                    }
                    System.out.println(sb);
                    sb.delete(0,sb.length());
                }
            }
        }
    }

}
