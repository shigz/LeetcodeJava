package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/8
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] charArr1 = num1.toCharArray();
        char[] charArr2 = num2.toCharArray();
        int first = charArr1.length - 1;
        int second = charArr2.length - 1;
        int remain = 0;
        while (first >= 0 || second >= 0) {
            int sum = (first >= 0 ? charArr1[first] - '0' : 0) + (second >= 0 ? charArr2[second] - '0' : 0) + remain;
            sb.append(sum % 10);
            remain = sum / 10;
            first--;
            second--;
        }
        if (remain != 0) sb.append(remain);
        return sb.reverse().toString();
    }

}
