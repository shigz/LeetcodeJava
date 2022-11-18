package shigz.learn.y22.m11;

import java.util.*;

/**
 * Created by 大史 on 2022/11/4
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int n = people.length;
        int[][] resultMatrix = new int[n][];
        for (int[] person:people) {
            int spaces = person[1] + 1;
            for (int i = 0;i< n;i++) {
                if (resultMatrix[i] == null){
                    spaces--;
                    if (spaces == 0) {
                        resultMatrix[i] = person;
                        break;
                    }
                }
            }
        }
        return resultMatrix;
    }

    //空间占用较大,且速度较慢
    public int[][] firstTry(int[][] people) {
        //存放身高对应的前面的人的个数
        Map<Integer, Set<Integer>> heightCountSetMap = new TreeMap<>();
        //存放当前排序好的数组中大于某个高度的人有几个
        Map<Integer, Integer> heightPreCountMap = new HashMap<>();
        //将高度和前面人的个数加入到 Map 中
        for (int[] heightCount : people) {
            int height = heightCount[0];
            int count = heightCount[1];
            if (heightCountSetMap.containsKey(height)) {
                heightCountSetMap.get(height).add(count);
            } else {
                Set<Integer> countSet = new HashSet<>();
                countSet.add(count);
                heightCountSetMap.put(height, countSet);
                heightPreCountMap.put(height, 0);
            }
        }
        int index = 0;
        while (index < people.length) {
            for (Map.Entry<Integer, Set<Integer>> entry:heightCountSetMap.entrySet()) {
                Integer height = entry.getKey();
                Integer value = heightPreCountMap.get(height);
                if (entry.getValue().contains(value)) {
                    people[index][0] = height;
                    people[index][1] = value;
                    index++;
                    for (Integer preHeight:heightCountSetMap.keySet()) {
                        if (preHeight <= height) {
                            heightPreCountMap.put(preHeight,heightPreCountMap.get(preHeight) + 1);
                        } else break;
                    }
                    break;
                }
            }
        }
        return people;
    }

}
