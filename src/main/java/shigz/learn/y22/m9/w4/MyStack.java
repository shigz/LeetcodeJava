package shigz.learn.y22.m9.w4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 大史 on 2022/9/29
 */
public class MyStack {

    private final Queue<Integer> myQueue;

    public MyStack() {
        this.myQueue = new LinkedList<>();
    }

    public void push(int x) {
        myQueue.add(x);
        for( int i = myQueue.size() - 1; i > 0; i--){
            myQueue.add(myQueue.remove());
        }
    }

    public int pop() {
        return myQueue.remove();
    }

    public int top() {
        return myQueue.peek();
    }

    public boolean empty() {
        return myQueue.isEmpty();
    }

}
