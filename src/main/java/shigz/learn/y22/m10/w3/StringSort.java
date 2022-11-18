package shigz.learn.y22.m10.w3;

import shigz.common.BaseObject;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/20
 */
public class StringSort extends BaseObject {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] charArr = in.nextLine().toCharArray();
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < charArr.length; i++) {
            int count = getCount(charArr[i]);
            if (count != -1) {
                char currentChar = charArr[i];
                int current = i;
                int preIndex = getNextPreIndex(charArr, current - 1, count);
                while (preIndex != -1) {
                    charArr[current] = charArr[preIndex];
                    current = preIndex;
                    preIndex = getNextPreIndex(charArr, current - 1, count);
                }
                if (current != i) charArr[current] = currentChar;
            }

        }
        System.out.println(new String(charArr));
    }

    private static int getNextPreIndex(char[] charArr, int fromIndex, int count) {
        if (fromIndex >= 0) {
            if (charArr[fromIndex] >= 'a' && charArr[fromIndex] <= 'z') {
                if (count < charArr[fromIndex]) return fromIndex;
            } else if (charArr[fromIndex] >= 'A' && charArr[fromIndex] <= 'Z') {
                if (count < charArr[fromIndex] - 'A' + 'a') return fromIndex;
            }
            return getNextPreIndex(charArr, fromIndex - 1, count);
        } else return -1;
    }

    private static int getCount(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 'a';
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 'a';
        } else return -1;
    }

}
