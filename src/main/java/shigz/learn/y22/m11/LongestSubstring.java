package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/2
 */
public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        return firstTry(s,k);
    }

    //这样滑动效率较差
    public int firstTry(String s, int k) {
        char[] charArr = s.toCharArray();
        //记录每个字符的总个数
        int[] charCountArr = new int[26];
        for (char c : charArr) {
            charCountArr[c - 'a']++;
        }
        int n = s.length();
        if (isValid(charCountArr, k)) return n;
        n--;
        while (n >= k) {
            if (n % 2 == 0) {
                //偶数从左向右滑
                charCountArr[charArr[n] - 'a']--;
                if (isValid(charCountArr, k)) return n;
                int index = 0;
                while (index + n < charArr.length) {
                    charCountArr[charArr[index] - 'a']--;
                    charCountArr[charArr[index + n] - 'a']++;
                    if (isValid(charCountArr, k)) return n;
                    index++;
                }
            } else {
                //奇数从右向左滑
                charCountArr[charArr[s.length() - 1 - n] - 'a']--;
                if (isValid(charCountArr, k)) return n;
                int index = s.length() - 1;
                while (index - n >= 0) {
                    charCountArr[charArr[index] - 'a']--;
                    charCountArr[charArr[index - n] - 'a']++;
                    if (isValid(charCountArr, k)) return n;
                    index--;
                }
            }
            n--;
        }
        return 0;
    }

    private boolean isValid(int[] charCountArr, int k) {
        for (int count : charCountArr) {
            if (count > 0 && count < k) return false;
        }
        return true;
    }

}
