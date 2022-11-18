package shigz.learn.y22.m10.w4;

import java.util.Stack;

/**
 * Created by 大史 on 2022/11/1
 */
public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        //记录当前差值为正还是为负
        boolean isUp = false;
        int index = 1;
        while (index < nums.length) {
            if (nums[index] > stack.peek()) {
                //差值为正
                stack.push(nums[index]);
                isUp = true;
                break;
            } else if (nums[index] < stack.peek()) {
                stack.push(nums[index]);
                break;
            }
            index++;
        }

        while (index < nums.length) {
            if (nums[index] > stack.peek()) {
                if (isUp) {
                    //当前差值为正,则更换栈顶元素,让差值更大
                    stack.pop();
                    stack.push(nums[index]);
                } else {
                    //当前差值为负,入栈,且更新当前差值为正
                    stack.push(nums[index]);
                    isUp = true;
                }
            } else if (nums[index] < stack.peek()) {
                if (isUp) {
                    //当前差值为正,入栈,且更新当前差值为负
                    stack.push(nums[index]);
                    isUp = false;
                } else {
                    //当前差值为负,则更换栈顶元素,让差值更小
                    stack.pop();
                    stack.push(nums[index]);
                }
            }
            index++;
        }
        return stack.size();
    }

}
