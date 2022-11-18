package shigz.learn.y22.m11;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by 大史 on 2022/11/2
 */
public class DecodeString {


    public String decodeString(String s) {
        return getString(s.toCharArray());
    }

    //数字和字母两个栈
    private String getString(char[] charArr) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> textStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < charArr.length) {
            char c = charArr[index];
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
                index++;
                while (index < charArr.length && charArr[index] >= 'a' && charArr[index] <= 'z') {
                    sb.append(charArr[index]);
                    index++;
                }
                textStack.add(sb.toString());
                sb.delete(0, sb.length());
            } else if (c >= '1' && c <= '9') {
                sb.append(c);
                index++;
                while (index < charArr.length && charArr[index] >= '0' && charArr[index] <= '9') {
                    sb.append(charArr[index]);
                    index++;
                }
                numStack.add(Integer.parseInt(sb.toString()));
                sb.delete(0, sb.length());
            } else if (c == ']') {
                int count = numStack.pop();
                String temp = "";
                String current = textStack.pop();
                while (!current.equals("[")) {
                    temp = current + temp;
                    current = textStack.pop();
                }
                for (int i = 0; i < count; i++) {
                    sb.append(temp);
                }
                textStack.add(sb.toString());
                sb.delete(0, sb.length());
                index++;
            } else {
                textStack.add("[");
                index++;
            }
        }
        String result = "";
        while (!textStack.isEmpty()) {
            result = textStack.pop() + result;
        }
        return result;
    }

    //递归方案 由于使用全局变量存放当前索引,导致不能进行异步操作,实际编程中并不可取,但速度还成
    private int startIndex = 0;

    private String firstTry(String s, char[] charArr) {
        StringBuilder sb = new StringBuilder();
        while (startIndex < charArr.length) {
            char c = charArr[startIndex];
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
                startIndex++;
            } else if (c >= '1' && c <= '9') {
                int endIndex = s.indexOf('[', startIndex);
                int count = Integer.parseInt(s.substring(startIndex, endIndex));
                startIndex = endIndex + 1;
                String subStr = firstTry(s, charArr);
                for (int i = 0; i < count; i++) {
                    sb.append(subStr);
                }
            } else if (c == ']') {
                startIndex++;
                break;
            }
        }
        return sb.toString();
    }

}
