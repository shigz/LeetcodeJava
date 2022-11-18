package shigz.learn.y22.m9.w3;

import java.util.*;

/**
 * Created by 大史 on 2022/9/22
 */
public class MaxPoints {

    //三次循环
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = 2;
        for (int i = 0; i < n - 2; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n - 1; j++) {
                int cnt = 2;
                int x2 = points[j][0];
                int y2 = points[j][1];
                double slope = y1 == y2 ? 0 : x2 == x1 ? Double.POSITIVE_INFINITY : (y2 - y1) * 1.0 / (x2 - x1);
                for (int k = j + 1; k < n; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    double slope3 = y2 == y3 ? 0 : x2 == x3 ? Double.POSITIVE_INFINITY : (y3 - y2) * 1.0 / (x3 - x2);
                    if (slope == slope3) cnt++;
                }
                result = Math.max(cnt,result);
            }
        }
        return result;
    }

    //多层次储存,内存消耗大
    public int firstTry(int[][] points) {
        if (points.length == 1) return 1;
        Map<Double, List<Set<Integer>>> slopeIndexMap = new HashMap<>();
        Set<Integer> computedIndexSet = new HashSet<>();
        int i = 1;
        while (i < points.length) {
            for (int j = 0; j < i; j++) {
                if (!computedIndexSet.contains(j)) {
                    Double slope = points[i][1] == points[j][1] ? Double.POSITIVE_INFINITY : (points[i][0] - points[j][0]) * 1.0 / (points[i][1] - points[j][1]);
                    if (slope == -0.0) {
                        slope = 0.0;
                    }
                    if (slopeIndexMap.containsKey(slope)) {
                        List<Set<Integer>> indexSetList = slopeIndexMap.get(slope);
                        boolean flag = false;
                        for (Set<Integer> indexSet : indexSetList) {
                            if (indexSet.contains(j)) {
                                computedIndexSet.addAll(indexSet);
                                indexSet.add(i);
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            computedIndexSet.add(j);
                            Set<Integer> indexSet = new HashSet<>();
                            indexSet.add(i);
                            indexSet.add(j);
                            indexSetList.add(indexSet);
                        }
                    } else {
                        computedIndexSet.add(j);
                        List<Set<Integer>> indexSetList = new ArrayList<>();
                        Set<Integer> indexSet = new HashSet<>();
                        indexSet.add(i);
                        indexSet.add(j);
                        indexSetList.add(indexSet);
                        slopeIndexMap.put(slope, indexSetList);
                    }
                }
            }
            computedIndexSet.clear();
            i++;
        }
        int result = 1;
        for (List<Set<Integer>> indexSetList : slopeIndexMap.values()) {
            for (Set<Integer> indexSet : indexSetList) {
                if (indexSet.size() > result) {
                    result = indexSet.size();
                }
            }
        }
        return result;
    }

}
