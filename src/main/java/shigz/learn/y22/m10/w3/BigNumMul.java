package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/17
 */
public class BigNumMul {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return null;
        if ("0".equals(s) || "0".equals(t)) return "0";
        int[] numArr = new int[s.length() + t.length() - 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0;j < t.length();j++) {
                numArr[i + j] += (s.charAt(i) - '0') * (t.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = numArr.length - 1;i >= 0;i--) {
            int temp = numArr[i] + carry;
            sb.append(temp % 10);
            carry = temp / 10;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

}
