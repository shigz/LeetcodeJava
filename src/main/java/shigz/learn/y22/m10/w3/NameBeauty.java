package shigz.learn.y22.m10.w3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 大史 on 2022/10/21
 */
public class NameBeauty {

    public static void main(String[] args) {
        System.out.println(maxBeauty("zhangsan".toCharArray()));
    }

    private static int maxBeauty(char[] charArr) {
        int[] charCountArr = new int[26];
        for (char c:charArr) {
            charCountArr[c - 'a'] += 1;
        }
        TreeMap<Integer,Integer> countCountMap = new TreeMap<>(Comparator.reverseOrder());
        for (int count:charCountArr) {
            countCountMap.put(count,1 + countCountMap.getOrDefault(count,0));
        }
        int result = 0;
        int now = 26;
        for (Map.Entry<Integer,Integer> entry:countCountMap.entrySet()) {
            for (int i = 0; i < entry.getValue();i++) {
                result += entry.getKey() * now;
                now--;
            }
        }
        return result;
    }

}
