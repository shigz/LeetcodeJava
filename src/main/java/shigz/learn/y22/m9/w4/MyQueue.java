package shigz.learn.y22.m9.w4;

import java.util.Stack;

/**
 * Created by 大史 on 2022/9/30
 */
public class MyQueue {

    private final Stack<Integer> myStack = new Stack<>();
    private final Stack<Integer> tempStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!myStack.isEmpty()) {
            tempStack.push(myStack.pop());
        }
        myStack.push(x);
        while (!tempStack.isEmpty()) {
            myStack.push(tempStack.pop());
        }
    }

    public int pop() {
        return myStack.pop();
    }

    public int peek() {
        return myStack.peek();
    }

    public boolean empty() {
        return myStack.isEmpty();
    }

}
