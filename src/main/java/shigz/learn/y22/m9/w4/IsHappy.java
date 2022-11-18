package shigz.learn.y22.m9.w4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 大史 on 2022/9/27
 */
public class IsHappy {

    public boolean isHappy(int n) {
        int current = n;
        Set<Integer> resultSet = new HashSet<>();
        while (!resultSet.contains(current)) {
            if (1 == current) return true;
            resultSet.add(current);
            current = getNextNum(current);
        }
        return false;
    }

    private int getNextNum(int n) {
        int result = 0;
        while (n > 0) {
            int remain = n % 10;
            result = result + remain * remain;
            n = n / 10;
        }
        return result;
    }

}
