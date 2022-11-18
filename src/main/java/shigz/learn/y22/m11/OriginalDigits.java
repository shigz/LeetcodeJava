package shigz.learn.y22.m11;

import java.util.*;

/**
 * Created by 大史 on 2022/11/10
 */
public class OriginalDigits {

    public String originalDigits(String s) {
        //存储每个字符的总个数
        Map<Character, Integer> charCountMap = new HashMap<>();
        int[] numCountArr = new int[10];
        //逐个字符加入到 charCountMap
        for (char c : s.toCharArray()) {
            charCountMap.put(c, 1 + charCountMap.getOrDefault(c, 0));
        }
        //逐个将字符加入到数字总数数组
        numCountArr[0] = charCountMap.getOrDefault('z', 0);
        numCountArr[2] = charCountMap.getOrDefault('w', 0);
        numCountArr[4] = charCountMap.getOrDefault('u', 0);
        numCountArr[8] = charCountMap.getOrDefault('g', 0);
        numCountArr[6] = charCountMap.getOrDefault('x', 0);
        numCountArr[7] = charCountMap.getOrDefault('s', 0) - numCountArr[6];
        numCountArr[5] = charCountMap.getOrDefault('f', 0) - numCountArr[4];
        numCountArr[3] = charCountMap.getOrDefault('h', 0) - numCountArr[8];
        numCountArr[1] = charCountMap.getOrDefault('o', 0) - numCountArr[0] - numCountArr[2] - numCountArr[4];
        numCountArr[9] = charCountMap.getOrDefault('i', 0) - numCountArr[5] - numCountArr[6] - numCountArr[8];
        //将数字加入到最终结果中
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < 10; index++) {
            for (int i = 0; i < numCountArr[index]; i++) {
                sb.append(index);
            }
        }
        return sb.toString();
    }

}
