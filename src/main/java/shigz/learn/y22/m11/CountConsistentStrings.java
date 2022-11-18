package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/8
 */
public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] hasCharArr = new boolean[26];
        for (char c : allowed.toCharArray()) {
            hasCharArr[c - 'a'] = true;
        }
        int result = 0;
        for (String word : words) {
            if (isConsistent(word.toCharArray(), hasCharArr)) result++;
        }
        return result;
    }

    private boolean isConsistent(char[] charArr, boolean[] hasCharArr) {
        for (char c : charArr) {
            if (!hasCharArr[c - 'a']) return false;
        }
        return true;
    }

}
