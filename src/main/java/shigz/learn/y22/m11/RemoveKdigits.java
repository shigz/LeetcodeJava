package shigz.learn.y22.m11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 大史 on 2022/11/3
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

    private int dfs(int[] numArr, int currentIndex, int k, int sum) {
        if (k == 0) {
            if (currentIndex < numArr.length) {
                return dfs(numArr, currentIndex + 1, 0, sum * 10 + numArr[currentIndex]);
            } else return sum;
        } else {
            if (k + currentIndex == numArr.length) {
                return sum;
            } else {
                return Math.min(dfs(numArr, currentIndex + 1, k - 1, sum), dfs(numArr, currentIndex + 1, k, sum * 10 + numArr[currentIndex]));
            }
        }
    }

}
