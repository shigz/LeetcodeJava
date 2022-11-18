package shigz.learn.y22.m10.w3;

import shigz.common.BaseObject;

import java.util.*;

/**
 * Created by 大史 on 2022/10/20
 */
public class BrotherWords extends BaseObject {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dictCount = in.nextInt();
        String[] dictArr = new String[dictCount];
        for (int i = 0; i < dictCount; i++) {
            dictArr[i] = in.next();
        }
        String target = in.next();
        int[] charCountArr = new int[26];
        for (char c : target.toCharArray()) {
            charCountArr[c - 'a'] += 1;
        }
        int brotherIndex = in.nextInt();
        TreeMap<String, Integer> brotherMap = new TreeMap<>();
        for (String dict : dictArr) {
            if (dict.length() == target.length() && !dict.equals(target)) {
                if (!brotherMap.containsKey(dict)) {
                    if (isBrother(dict, charCountArr.clone())) brotherMap.put(dict, 1);
                } else {
                    brotherMap.put(dict, brotherMap.get(dict) + 1);
                }
            }
        }

        int count = 0;
        String brother = "";
        for (Map.Entry<String,Integer> entry : brotherMap.entrySet()) {
            count += entry.getValue();
            if (brother.equals("") && count >= brotherIndex) brother = entry.getKey();
        }
        System.out.println(count);
        System.out.println(brother);
    }

    private static boolean isBrother(String dict, int[] charCountArr) {
        for (char c : dict.toCharArray()) {
            int charIndex = c - 'a';
            if (charCountArr[charIndex] == 0) return false;
            charCountArr[charIndex] -= 1;
        }
        return true;
    }

}
