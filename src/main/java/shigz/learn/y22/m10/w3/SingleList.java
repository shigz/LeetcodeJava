package shigz.learn.y22.m10.w3;

import java.util.Stack;

/**
 * Created by 大史 on 2022/10/21
 */
public class SingleList {

    public static void main(String[] args) {
        int delNum = 2;
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        addTo(numStack,tempStack,1,2);
        addTo(numStack,tempStack,3,2);
        addTo(numStack,tempStack,5,1);
        addTo(numStack,tempStack,4,5);
        addTo(numStack,tempStack,7,2);
        StringBuilder sb = new StringBuilder();
        while (!numStack.isEmpty()) {
            tempStack.add(numStack.pop());
        }
        while (!tempStack.isEmpty()) {
            int num = tempStack.pop();
            if (num != delNum) {
                if (0 < sb.length()) sb.append(" ");
                sb.append(num);
            }
        }
        System.out.println(sb);
    }

    private static void addTo(Stack<Integer> numStack,Stack<Integer> tempStack,int num,int pre) {
        if (numStack.isEmpty()) {
            numStack.add(pre);
            numStack.add(num);
        } else {
            while (numStack.peek() != pre) {
                tempStack.add(numStack.pop());
            }
            numStack.add(num);
            while (!tempStack.isEmpty()) {
                numStack.add(tempStack.pop());
            }
        }
    }

}
