package shigz.learn.y22.m10.w3;

import shigz.common.BaseObject;

/**
 * Created by 大史 on 2022/10/17
 */
public class BigAnd extends BaseObject {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve (String s, String t) {
        StringBuilder sb = new StringBuilder();
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        int remain = 0;
        while (index1 >= 0 && index2 >= 0) {
            int sum = s.charAt(index1) - '0' + t.charAt(index2) - '0' + remain;
            sb.append(sum % 10);
            remain = sum / 10;
            index1--;
            index2--;
        }
        while (0 <= index1) {
            int sum = s.charAt(index1) - '0' + remain;
            sb.append(sum % 10);
            remain = sum / 10;
            index1--;
        }
        while (0 <= index2) {
            int sum = t.charAt(index2) - '0' + remain;
            sb.append(sum % 10);
            remain = sum / 10;
            index2--;
        }
        if (0 < remain) sb.append(remain);
        return sb.reverse().toString();
        // write code here
    }

    public static void main(String[] args) {
        infoLog(solve("114514", "99999"));
    }

}
