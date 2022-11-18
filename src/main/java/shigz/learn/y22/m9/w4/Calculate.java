package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/29
 */
public class Calculate {

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        int currentResult = 0;
        boolean isAdd = true;
        int index = 0;
        while (index < s.length()) {
            switch (s.charAt(index)) {
                case '(': {
                    int[] nextResult = calFrom(s, index + 1);
                    index = nextResult[1];
                    currentResult = isAdd ? currentResult + nextResult[0] : currentResult - nextResult[0];
                    break;
                }
                case ')': {
                    return 0;
                }
                case '+': {
                    if (0 < sb.length()) {
                        currentResult = currentResult + (isAdd ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString()));
                        sb.delete(0,sb.length());
                    }
                    isAdd = true;
                    break;
                }
                case '-': {
                    if (0 < sb.length()) {
                        currentResult = currentResult + (isAdd ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString()));
                        sb.delete(0,sb.length());
                    }
                    isAdd = false;
                    break;
                }
                case ' ': break;
                default:
                    sb.append(s.charAt(index));
            }
            index++;
        }
        if (0 < sb.length()) {
            currentResult = currentResult + (isAdd ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString()));
            sb.delete(0,sb.length());
        }
        return currentResult;
    }

    private int[] calFrom(String s, int index) {
        StringBuilder sb = new StringBuilder();
        int currentResult = 0;
        boolean isAdd = true;
        while (index < s.length()) {
            switch (s.charAt(index)) {
                case '(': {
                    int[] nextResult = calFrom(s, index + 1);
                    index = nextResult[1];
                    currentResult = isAdd ? currentResult + nextResult[0] : currentResult - nextResult[0];
                    break;
                }
                case ')': {
                    if (0 < sb.length()) {
                        currentResult = currentResult + (isAdd ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString()));
                        sb.delete(0,sb.length());
                    }
                    return new int[]{currentResult, index};
                }
                case '+': {
                    if (0 < sb.length()) {
                        currentResult = currentResult + (isAdd ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString()));
                        sb.delete(0,sb.length());
                    }
                    isAdd = true;
                    break;
                }
                case '-': {
                    if (0 < sb.length()) {
                        currentResult = currentResult + (isAdd ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString()));
                        sb.delete(0,sb.length());
                    }
                    isAdd = false;
                    break;
                }
                case ' ': break;
                default:
                    sb.append(s.charAt(index));
            }
            index++;
        }
        return new int[]{};
    }

}
