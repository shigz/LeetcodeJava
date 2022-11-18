package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/10
 */
public class IsAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);
    }

    private boolean dfs(String num, int index, int count, long prevPrev, long prev) {
        if (index >= num.length()) return count > 2;
        long current = 0;
        for (int currentIndex = index; currentIndex < num.length(); currentIndex++) {
            char c = num.charAt(currentIndex);
            if (num.charAt(index) == '0' && currentIndex > index) {
                return false;
            }
            current = current * 10 + c - '0';
            if (count >= 2) {
                long sum = prev + prevPrev;
                if (current > sum) {
                    return false;
                }
                if (current < sum) {
                    continue;
                }
            }
            if (dfs(num, currentIndex + 1, count + 1, prev, current)) {
                return true;
            }
        }
        return false;
    }

}
