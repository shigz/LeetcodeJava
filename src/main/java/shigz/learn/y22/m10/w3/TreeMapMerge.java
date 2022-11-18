package shigz.learn.y22.m10.w3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by 大史 on 2022/10/18
 */
public class TreeMapMerge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int count = in.nextInt();
        TreeMap<Integer, Integer> resultMap = new TreeMap<>();
        while (0 < count) {
            String[] textArr = in.nextLine().split(" ");
            if (2 == textArr.length) {
                int key = Integer.parseInt(textArr[0]);
                int value = Integer.parseInt(textArr[1]);
                resultMap.put(key, value + resultMap.getOrDefault(key, 0));
                count--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            if (0 < sb.length()) sb.append("\n");
            sb.append(entry.getKey()).append(" ").append(entry.getValue());
        }
        System.out.println(sb);
    }

}
