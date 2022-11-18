package shigz.learn.y22.m9.w3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by 大史 on 2022/9/22
 */
public class ReverseWords {
    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                if (0 < sb.length()) {
                    stack.push(sb.toString());
                    sb.delete(0,sb.length());
                }
            } else {
                sb.append(s.charAt(index));
            }
            index++;
        }
        if (0 < sb.length()) {
            stack.push(sb.toString());
            sb.delete(0,sb.length());
        }
        sb.append(stack.pop());
        while (0 < stack.size()) {
            sb.append(" ").append(stack.pop());
        }
        return sb.toString();
    }
}
