package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/19
 */
public class IsPalindrome {

    public boolean secondTry(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            int[] nextLeftCharArr = arrNextChar(s, left, 1);
            int[] nextRightCharArr = arrNextChar(s, right, -1);
            if (nextLeftCharArr[1] < nextRightCharArr[1] && nextLeftCharArr[0] != nextRightCharArr[0]) {
                return false;
            }
            left = nextLeftCharArr[1] + 1;
            right = nextRightCharArr[1] - 1;
        }
        return true;
    }

    private int[] arrNextChar(String s, int index, int flag) {
        if (index >= 0 && index < s.length()) {
            int currentChar = s.charAt(index);
            if ((currentChar >= 48 && currentChar <= 57) || (currentChar >= 97 && currentChar <= 122)) {
                return new int[]{currentChar, index};
            } else if (currentChar >= 65 && currentChar <= 90) {
                return new int[]{currentChar + 32, index};
            } else {
                return arrNextChar(s, index + flag, flag);
            }
        } else return new int[]{' ', index};
    }

    public boolean firstTry(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            if ((currentChar >= 48 && currentChar <= 57) || (currentChar >= 97 && currentChar <= 122)) {
                sb.append(currentChar);
            } else if (currentChar >= 65 && currentChar <= 90) {
                sb.append((char) (currentChar + 32));
            }
            index += 1;
        }
        int newIndex = 0;
        while (newIndex < sb.length() / 2) {
            if (sb.charAt(newIndex) != sb.charAt(sb.length() - 1 - newIndex)) {
                return false;
            }
            newIndex += 1;
        }
        return true;
    }

}
