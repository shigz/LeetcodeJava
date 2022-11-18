package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/11
 */
public class AreAlmostEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        int diffCount = 0;
        Character pre1 = null;
        Character pre2 = null;
        int index = 0;
        while (index < s1.length()) {
            if (s1.charAt(index) != s2.charAt(index)) {
                if (diffCount == 0) {
                    pre1 = s1.charAt(index);
                    pre2 = s2.charAt(index);
                    diffCount++;
                } else if (diffCount == 1) {
                    if (s1.charAt(index) == pre2 && s2.charAt(index) == pre1) {
                        diffCount++;
                        pre1 = null;
                        pre2 = null;
                    } else return false;
                } else {
                    return false;
                }
            }
            index++;
        }
        return diffCount == 0 || diffCount == 2;
    }

}
