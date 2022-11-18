package shigz.learn.y22.m10.w3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/10/20
 */
public class GetPassword2 {

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        add(numList,"trailblazers".toCharArray());
        for ( int i = 0;i < 26;i++) {
            add(numList,i);
        }
        StringBuilder sb = new StringBuilder();
        for (char c:"attack at dawn".toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append(((char)(numList.get(c - 'a') + 'a')));
            } else sb.append(c);

        }
        System.out.println(sb);
    }

    private static void add(List<Integer> numList, char[] charArr) {
        for (char c : charArr) {
            add(numList, c - 'a');
        }
    }

    private static void add(List<Integer> numList, int num) {
        if (!numList.contains(num)) {
            numList.add(num);
        }
    }

}
