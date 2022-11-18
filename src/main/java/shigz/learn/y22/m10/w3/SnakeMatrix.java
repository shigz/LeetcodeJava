package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/20
 */
public class SnakeMatrix {

    public static void main(String[] args) {
        printSnake(10);
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        printSnake(in.nextInt());
    }

    private static void printSnake(int max) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int temp = 1;
        while (index < max) {
            int subTemp = temp;
            for (int i = index + 2;i <= max;i++) {
                sb.append(subTemp).append(' ');
                subTemp += i;
            }
            sb.append(subTemp).append('\n');
            index++;
            temp += index;
        }
        System.out.println(sb);
    }

}
