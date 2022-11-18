package shigz.learn.y22.m10.w4;

import shigz.learn.y22.m10.w2.nested.NestedInt;
import shigz.learn.y22.m10.w2.nested.NestedInteger;

import java.util.Stack;

/**
 * Created by 大史 on 2022/11/1
 */
public class NestedIntegerFactory {

    public NestedInteger deserialize(String s) {
        Stack<Integer> stack = new Stack<>();
        int startIndex = 0;
        int currentIndex = 0;
        char[] charArr = s.toCharArray();
        //逐个提取值之后入栈
        while (currentIndex < charArr.length) {
            if (charArr[currentIndex] == ',' || charArr[currentIndex] == ']') {
                if (startIndex < currentIndex) {
                    stack.push(Integer.parseInt(s.substring(startIndex,currentIndex)));
                }
                startIndex = currentIndex + 1;
            } else if (charArr[currentIndex] == '[') {
                startIndex = currentIndex + 1;
            }
            currentIndex++;
        }
        if (startIndex < currentIndex) {
            stack.push(Integer.parseInt(s.substring(startIndex,currentIndex)));
        }
        //嵌套创建 NestedInteger
        return new NestedInt(1);
    }

}
