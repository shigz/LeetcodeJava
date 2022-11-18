package shigz.learn.y22.m9.w3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by 大史 on 2022/9/22
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        if (1 == tokens.length) return Integer.parseInt(tokens[0]);
        Deque<Integer> resultStack = new ArrayDeque<>();
        int index = 0;
        while (index < tokens.length) {
            switch (tokens[index]) {
                case "+":
                    resultStack.push(resultStack.pop() + resultStack.pop());
                    break;
                case "-":
                    int num1 = resultStack.pop();
                    int num2 = resultStack.pop();
                    resultStack.push(num2 - num1);
                    break;
                case "*":
                    resultStack.push(resultStack.pop() * resultStack.pop());
                    break;
                case "/":
                    int num3 = resultStack.pop();
                    int num4 = resultStack.pop();
                    resultStack.push(num4 / num3);
                    break;
                default:
                    resultStack.push(Integer.parseInt(tokens[index]));
            }
            index++;
        }
        return resultStack.pop();
    }

}
