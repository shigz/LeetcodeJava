package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/8
 */
public class IsAnagram {

    //26 位字母做索引,s 对应的 char 记为 1,t 对应的 char 记为 -1,异位词最终应全为 0
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] countArr = new int[26];
        int index = 0;
        while (index < s.length()) {
            countArr[s.charAt(index) - 97]++;
            countArr[t.charAt(index) - 97]--;
            index++;
        }
        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) return false;
        }
        return true;
    }

}
