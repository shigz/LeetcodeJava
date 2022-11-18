package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/14
 */
public class DistinctSubseqII {
    private static final int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] charCountArr = new int[26];
        charCountArr[s.charAt(0) - 'a'] = 1;
        int total = 1;
        int index = 1;
        while (index < n) {
            int charIndex = s.charAt(index) - 'a';
            int preTotal = total;
            total = ((2 * preTotal + 1 - charCountArr[charIndex]) % MOD + MOD)% MOD;
            charCountArr[charIndex] = ((charCountArr[charIndex] + total - preTotal) % MOD + MOD) % MOD;
            index++;
        }
        return total;
    }

    //两个数组,内存占用高
    public int firstTry(String s) {
        int n = s.length();
        long[] countArr = new long[n];
        long[] charCountArr = new long[26];
        countArr[0] = 1;
        charCountArr[s.charAt(0) - 'a'] = 1;
        int index = 1;
        while (index < n) {
            int charIndex = s.charAt(index) - 'a';
            countArr[index] = (2 * countArr[index - 1] + 1 - charCountArr[charIndex]);
            while (countArr[index] < 0) {
                countArr[index] += 1000000007;
            }
            countArr[index] = countArr[index] % 1000000007;
            charCountArr[charIndex] += countArr[index] - countArr[index - 1];
            while (charCountArr[charIndex] < 0) {
                charCountArr[charIndex] += 1000000007;
            }
            charCountArr[charIndex] = charCountArr[charIndex] % 1000000007;
            index++;
        }
        return (int) countArr[n - 1] % 1000000007;
    }

}
