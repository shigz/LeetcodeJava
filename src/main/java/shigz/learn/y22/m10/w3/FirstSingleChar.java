package shigz.learn.y22.m10.w3;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/24
 */
public class FirstSingleChar {

    public static void main(String[] args) {
        System.out.println(first("asdfasdfo".toCharArray()));
    }

    private static String first(char[] charArr) {
        Map<Character,Integer> charCountMap = new LinkedHashMap<>();
        for (char c:charArr) {
            charCountMap.put(c,1 + charCountMap.getOrDefault(c,0));
        }
        for (Map.Entry<Character,Integer> entry:charCountMap.entrySet()) {
            if (entry.getValue() == 1) return String.valueOf(entry.getKey());
        }
        return "-1";
    }

}
