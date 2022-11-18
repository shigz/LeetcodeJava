package shigz.learn.y22.m10.w4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 大史 on 2022/10/28
 */
public class SumSubArrayMins {

    //消元,单调栈
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long result = 0;
        int[] dp = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            int k = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            dp[i] = k * arr[i] + (stack.isEmpty() ? 0 : dp[i - k]);
            result = (result + dp[i]) % 1000000007;
            stack.push(i);
        }
        return (int) result;
    }

    //遍历,超时
    public int firstTry(int[] arr) {
        int n = arr.length;
        //定义结果二维数组
        //0 存放自当前数向前它为最小值的个数
        //1 存放它作为最小值的子数组个数
        long[][] dp = new long[n][2];
        dp[0] = new long[]{1, 1};
        //逐个初始化结果数组
        for (int i = 1; i < n; i++) {
            int count = 1;
            int j = i - 1;
            //寻找当前元素之前大于等于它的元素的个数
            while (j >= 0 && arr[j] > arr[i]) {
                count++;
                j--;
            }
            //将当前元素出现后新增加的 i + 1 个子数组的最小值分配下去
            dp[i] = new long[]{count, count};
            int index = i;
            while (index >= 0 && index >= dp[index][0]) {
                dp[index - (int) dp[index][0]][1] += dp[index - (int) dp[index][0]][0];
                index -= dp[index][0];
            }
        }
        long result = 0;
        //遍历最小值数组,加和最小值并取余进行标准化
        for (int i = 0; i < n; i++) {
            result = (result + dp[i][1] * arr[i]) % 1000000007;
        }
        return (int) result;
    }

}
