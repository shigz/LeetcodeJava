package shigz.learn.y22.m10.w4;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 大史 on 2022/10/25
 */
public class MatrixMulCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }
            String s = in.next();
            Stack<Integer> stack = new Stack<>();                 // 存放矩阵行数和列数
            int sum = 0;
            for (int i = s.length() - 1, j = n - 1; i >= 0; i--) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {       // 属于字母则把相应的矩阵列数和行数入栈
                    stack.push(a[j][1]);
                    stack.push(a[j][0]);
                    j--;
                } else if (s.charAt(i) == '(') {                   // 括号：推出计算
                    int x0 = stack.pop(), y0 = stack.pop();     // 矩阵尺寸x0*y0
                    int x1 = stack.pop(), y1 = stack.pop();     // 矩阵尺寸x1*y1
                    sum += x0 * y0 * y1;      // 两个矩阵的乘法次数为x0*y0*y1或x0*x1*y1（其中y0==x1）
                    stack.push(y1);       // 把相乘后得到的矩阵列数入栈
                    stack.push(x0);       // 把相乘后得到的矩阵行数入栈
                }
            }
            System.out.println(sum);
        }
    }

    private static int maxCount(char[] patternCharArr, int[][] lengthMatrix) {
        int result = 0;
        //从后向前遍历
        int i = patternCharArr.length - 1;
        //当前为最后一个矩阵
        int j = lengthMatrix.length - 1;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0) {
            //为字母时,对应的行数和列入栈
            if (patternCharArr[i] >= 'A' && patternCharArr[i] <= 'Z') {
                //矩阵列数先入栈
                stack.push(lengthMatrix[j][1]);
                //矩阵行数入栈
                stack.push(lengthMatrix[j][0]);
                j--;
                //为左括号时,将矩阵中的值取出并进行计算
            } else if (patternCharArr[i] == '(') {
                int x0 = stack.pop();
                stack.pop();
                int y0 = stack.pop();
                int y1 = stack.pop();
                //乘积累加到结果
                result += x0 * y0 * y1;
                //相乘后的矩阵列数入栈
                stack.push(y1);
                //相乘后的行数入栈
                stack.push(x0);
            }
            i--;
        }
        return result;
    }

}
