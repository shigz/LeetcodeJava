package shigz.learn.y22.m10.w4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/27
 */
public class TwentyFourPoint {

    private static final boolean[] visited = new boolean[4];
    private static final Map<String, Integer> pokerValueMap = new HashMap<String, Integer>() {
        {
            put("A", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
        }
    };
    private static final String[] pokerArr = new String[]{"0","A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    public static void main(String[] args) {
        System.out.println(deal("K Q 6 K"));
    }

    private static String deal(String str) {
        String[] pokerArr = str.split(" ");
        if (pokerArr.length == 4) {
            int[] numArr = new int[4];
            for (int i = 0; i < 4; i++) {
                if (pokerValueMap.containsKey(pokerArr[i])) {
                    numArr[i] = pokerValueMap.get(pokerArr[i]);
                } else return "ERROR";
            }
            return dfs(numArr, 0, "");
        } else {
            return "ERROR";
        }
    }

    private static String dfs(int[] numArr, int pre, String preStr) {
        if (pre == 24 && visited[0] && visited[1] && visited[2] && visited[3]) {
            return preStr;
        }
        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (!preStr.equals("")) {
                    String add = dfs(numArr, pre + numArr[i], preStr + "+" + pokerArr[numArr[i]]);
                    if (!add.equals("NONE")) return add;
                    String subtract = dfs(numArr, pre - numArr[i], preStr + "-" + pokerArr[numArr[i]]);
                    if (!subtract.equals("NONE")) return subtract;
                    String mul = dfs(numArr, pre * numArr[i], preStr + "*" + pokerArr[numArr[i]]);
                    if (!mul.equals("NONE")) return mul;
                    if (pre % numArr[i] == 0) {
                        String divide = dfs(numArr, pre / numArr[i], preStr + "/" + pokerArr[numArr[i]]);
                        if (!divide.equals("NONE")) return divide;
                    }
                } else {
                    String value = dfs(numArr, numArr[i], pokerArr[numArr[i]]);
                    if (!value.equals("NONE")) return value;
                }
                visited[i] = false;
            }
        }

        return "NONE";
    }

}
