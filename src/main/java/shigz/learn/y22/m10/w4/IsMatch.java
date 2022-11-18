package shigz.learn.y22.m10.w4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 大史 on 2022/10/26
 */
public class IsMatch {

    private static boolean isMatch(String shortStr, String longStr) {
        Set<Character> charSet = new HashSet<>();
        for (char c : shortStr.toCharArray()) {
            charSet.add(c);
        }
        char[] longCharArr = longStr.toCharArray();
        int i = 0;
        while (i < longCharArr.length) {
            if (charSet.contains(longCharArr[i])) {
                charSet.remove(longCharArr[i]);
                if (charSet.isEmpty()) return true;
            }
            i++;
        }
        return false;
    }

}
