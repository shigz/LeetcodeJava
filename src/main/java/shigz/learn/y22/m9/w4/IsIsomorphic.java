package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/27
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        int[] posArr = new int[128];
        int[] reverseArr = new int[128];
        int index = 0;
        while (index < s.length()) {
            int leftChar = s.charAt(index);
            int rightChar = t.charAt(index);
            if (posArr[leftChar] != 0) {
                if (reverseArr[rightChar] != 0) {
                    if (posArr[leftChar] - 1 != rightChar || reverseArr[rightChar] - 1 != leftChar) {
                        return false;
                    }
                } else return false;
            } else {
                if (reverseArr[rightChar] != 0) {
                    return false;
                } else {
                    posArr[leftChar] = rightChar + 1;
                    reverseArr[rightChar] = leftChar + 1;
                }
            }
            index++;
        }
        return true;
    }

}
