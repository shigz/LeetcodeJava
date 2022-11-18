package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/10/26
 */
public class EgyptNum {

    public static void main(String[] args) {
        deal(8, 11);
    }

    private static void deal(int molecule, int denominator) {
        int i = denominator + 1;
        while (true) {
            if (i * molecule % denominator == 0) {
                TreeSet<Integer> resultSet = isTrue(i, i * molecule / denominator);
                if (resultSet != null) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : resultSet) {
                        if (0 < sb.length()) sb.append("+");
                        sb.append("1/").append(i / num);
                    }
                    System.out.println(sb);
                    break;
                }
            }
            i++;
        }
    }

    private static TreeSet<Integer> isTrue(int num, int target) {
        Map<Integer, TreeSet<Integer>> divisorSetMap = new HashMap<>();
        int sqrt = (int) Math.sqrt(num);
        for (int i = 1; i < sqrt; i++) {
            if (num % i == 0) {
                TreeSet<Integer> resultSet = addNum(i, divisorSetMap, target);
                if (resultSet != null) return resultSet;
                TreeSet<Integer> maxResultSet = addNum(num / i, divisorSetMap, target);
                if (maxResultSet != null) return maxResultSet;
            }
        }
        return sqrt * sqrt == num ? addNum(sqrt, divisorSetMap, target) : null;
    }

    private static TreeSet<Integer> addNum(int num, Map<Integer, TreeSet<Integer>> divisorSetMap, int target) {
        TreeSet<Integer> keySet = new TreeSet<>(Comparator.reverseOrder());
        keySet.addAll(divisorSetMap.keySet());
        for (Integer key : keySet) {
            TreeSet<Integer> resultSet = divisorSetMap.get(key);
            if ((key + num) == target) {
                resultSet.add(num);
                return resultSet;
            } else if ((key + num) < target) {
                TreeSet<Integer> newSet = new TreeSet<>(resultSet);
                newSet.add(num);
                divisorSetMap.put(num + key, newSet);
            }
        }
        TreeSet<Integer> resultSet = new TreeSet<>(Comparator.reverseOrder());
        resultSet.add(num);
        if (num == target) {
            return resultSet;
        } else if (num < target) {
            divisorSetMap.put(num, resultSet);
        }
        return null;
    }

}
