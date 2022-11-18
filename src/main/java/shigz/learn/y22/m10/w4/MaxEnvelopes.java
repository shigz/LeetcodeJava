package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/10/31
 */
public class MaxEnvelopes {

    public int firstTry(int[][] envelopes) {

        //借用 TreeMap 将数据进行按宽度升序,高度降序排列
        Map<Integer, Set<Integer>> widthHeightSetMap = new TreeMap<>();
        for (int[] envelope : envelopes) {
            if (widthHeightSetMap.containsKey(envelope[0])) {
                widthHeightSetMap.get(envelope[0]).add(envelope[1]);
            } else {
                Set<Integer> heightSet = new TreeSet<>(Comparator.reverseOrder());
                heightSet.add(envelope[1]);
                widthHeightSetMap.put(envelope[0], heightSet);
            }
        }
        int result = 0;
        //记录当前套起来的信封个数,并且将套起来的信封更新为高度最小的
        Map<Integer, Integer> countWidthMap = new HashMap<>();
        for (Set<Integer> heightSet : widthHeightSetMap.values()) {
            for (Integer height : heightSet) {
                int index = result;
                while (index != 0 && countWidthMap.get(index) >= height) {
                    index--;
                }
                if (!countWidthMap.containsKey(index + 1)) {
                    countWidthMap.put(index + 1, height);
                    result += 1;
                } else {
                    if (countWidthMap.get(index + 1) > height) {
                        countWidthMap.put(index + 1, height);
                    }
                }
            }
        }
        return result;
    }

}
