package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/11/1
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

}
