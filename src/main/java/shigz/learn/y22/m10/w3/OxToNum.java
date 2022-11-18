package shigz.learn.y22.m10.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/17
 */
public class OxToNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character, Integer> charNumMap = new HashMap<>();
        charNumMap.put('0', 0);
        charNumMap.put('1', 1);
        charNumMap.put('2', 2);
        charNumMap.put('3', 3);
        charNumMap.put('4', 4);
        charNumMap.put('5', 5);
        charNumMap.put('6', 6);
        charNumMap.put('7', 7);
        charNumMap.put('8', 8);
        charNumMap.put('9', 9);
        charNumMap.put('A', 10);
        charNumMap.put('B', 11);
        charNumMap.put('C', 12);
        charNumMap.put('D', 13);
        charNumMap.put('E', 14);
        charNumMap.put('F', 15);
        while (str != null && 0 < str.trim().length()) {
            if (str.startsWith("0x")) {
                int startIndex = 2;
                int result = 0;
                while (startIndex < str.length()) {
                    int num = charNumMap.get(str.charAt(startIndex));
                    result = result * 16 + num;
                    startIndex++;
                }
                System.out.println(result);
            } else if (str.startsWith("-0x")) {
                int startIndex = 3;
                int result = 0;
                while (startIndex < str.length()) {
                    int num = charNumMap.get(str.charAt(startIndex));
                    result = result * 16 + num;
                    startIndex++;
                }
                System.out.println(-result);
            }
            str = br.readLine();
        }

    }

}
