package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class MaxGcRatio {

    public static void main(String[] args) {
        System.out.println(getSubStr("ACGT",2));
    }

    private static String getSubStr(String str, int k) {
        char[] charArr = str.toCharArray();
        int endIndex = k - 1;
        int minNotGCCount = 0;
        for (int i = 0; i < k; i++) {
            if (charArr[i] != 'G' && charArr[i] != 'C') minNotGCCount++;
        }
        int currentNotGCCount = minNotGCCount;
        for (int i = k; i < charArr.length; i++) {
            if (charArr[i - k] != 'G' && charArr[i - k] != 'C') {
                if (charArr[i] == 'G' || charArr[i] == 'C') {
                    currentNotGCCount--;
                    if (currentNotGCCount < minNotGCCount) {
                        endIndex = i + 1;
                        minNotGCCount = currentNotGCCount;
                    }
                    if (minNotGCCount == 0) return str.substring(endIndex - k, endIndex);
                }
            } else {
                if (charArr[i] != 'G' && charArr[i] != 'C') {
                    currentNotGCCount++;
                }
            }
        }
        return str.substring(endIndex - k, endIndex);
    }

}
