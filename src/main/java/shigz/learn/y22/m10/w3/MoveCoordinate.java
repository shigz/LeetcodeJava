package shigz.learn.y22.m10.w3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/18
 */
public class MoveCoordinate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        int n = str.length();
        int[][] countMatrix = new int[n + 1][2];
        Map<Character, int[]> offsetMap = new HashMap<>();
        offsetMap.put('A', new int[]{-1, 0});
        offsetMap.put('S', new int[]{0, -1});
        offsetMap.put('D', new int[]{1, 0});
        offsetMap.put('W', new int[]{0, 1});
        for (int i = 0; i < n; i++) {
            countMatrix[i + 1][0] = countMatrix[i][0] + offsetMap.get(str.charAt(i))[0];
            countMatrix[i + 1][1] = countMatrix[i][1] + offsetMap.get(str.charAt(i))[1];
        }

        System.out.println(getResult(countMatrix,n));
    }

    private static int getResult(int[][] countMatrix,int n) {
        int result = (Math.abs(countMatrix[n][0]) + Math.abs(countMatrix[n][1])) / 2;
        if (result > 0) {
            while (result <= n) {
                for (int i = 0;i < n - result; i++) {
                    int count = Math.abs(countMatrix[n][0] + countMatrix[i][0] - countMatrix[i + result][0]) + Math.abs(countMatrix[n][1] + countMatrix[i][1] - countMatrix[i + result][1]);
                    System.out.println("count: " + count);
                    if (count == result) {
                        System.out.println("index: " + i);
                        return result;
                    }
                }
                result++;
            }
        }
        return result;
    }

}
