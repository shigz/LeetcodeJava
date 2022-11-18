package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/11/1
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] charCountArr = new int[26];

        for (char c:magazine.toCharArray()) {
            charCountArr[c - 'a']--;
        }
        for (char c:ransomNote.toCharArray()) {
            charCountArr[c - 'a']++;
            if (charCountArr[c - 'a'] > 0 ) return false;
        }
        return true;
    }

}
