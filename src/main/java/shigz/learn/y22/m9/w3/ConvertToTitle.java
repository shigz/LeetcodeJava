package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/23
 */
public class ConvertToTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int remain = (columnNumber - 1) % 26;
        int divisor = (columnNumber - 1) / 26;
        while (divisor != 0) {
            sb.append((char) (remain + 65));
            remain = (divisor - 1) % 26;
            divisor = (divisor - 1) / 26;
        }
        sb.append((char) (remain + 65));
        return sb.reverse().toString();
    }

}
