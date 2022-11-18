package shigz.learn.y22.m10.w3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 大史 on 2022/10/20
 */
public class StringMergeDeal {

    private static final Map<Character, Character> transferMap = new HashMap<>();

    static {
        transferMap.put('1', '8');
        transferMap.put('2', '4');
        transferMap.put('3', 'C');
        transferMap.put('4', '2');
        transferMap.put('5', 'A');
        transferMap.put('7', 'E');
        transferMap.put('8', '1');
        transferMap.put('A', '5');
        transferMap.put('a', '5');
        transferMap.put('B', 'D');
        transferMap.put('b', 'D');
        transferMap.put('C', '3');
        transferMap.put('c', '3');
        transferMap.put('D', 'B');
        transferMap.put('d', 'B');
        transferMap.put('E', '7');
        transferMap.put('e', '7');
        transferMap.put('f', 'F');
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        char[] str1 = in.next().toCharArray();
        char[] str2 = in.next().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> evenStack = new Stack<>();
        Stack<Character> oddStack = new Stack<>();
        Stack<Character> tmpStack = new Stack<>();
        boolean flag = true;
        for (char c : str1) {
            if (flag) {
                while (!oddStack.isEmpty() && oddStack.peek() < c) {
                    tmpStack.add(oddStack.pop());
                }
                oddStack.add(c);
                while (!tmpStack.isEmpty()) {
                    oddStack.add(tmpStack.pop());
                }
            } else {
                while (!evenStack.isEmpty() && evenStack.peek() < c) {
                    tmpStack.add(evenStack.pop());
                }
                evenStack.add(c);
                while (!tmpStack.isEmpty()) {
                    evenStack.add(tmpStack.pop());
                }
            }
            flag = !flag;
        }
        for (char c : str2) {
            if (flag) {
                while (!oddStack.isEmpty() && oddStack.peek() < c) {
                    tmpStack.add(oddStack.pop());
                }
                oddStack.add(c);
                while (!tmpStack.isEmpty()) {
                    oddStack.add(tmpStack.pop());
                }
            } else {
                while (!evenStack.isEmpty() && evenStack.peek() < c) {
                    tmpStack.add(evenStack.pop());
                }
                evenStack.add(c);
                while (!tmpStack.isEmpty()) {
                    evenStack.add(tmpStack.pop());
                }
            }
            flag = !flag;
        }
        while (!oddStack.isEmpty()) {
            sb.append(transfer(oddStack.pop()));
            if (!evenStack.isEmpty()) {
                sb.append(transfer(evenStack.pop()));
            }
        }
        System.out.println(sb);
    }

    private static char transfer(char c) {
        return transferMap.getOrDefault(c, c);
    }

}
