package shigz.learn.y22.m10.w3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 大史 on 2022/10/21
 */
public class Weights {

    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1, 2}, new int[]{2, 1}));
    }

    private static int maxCount(int[] weights, int[] counts) {
        Set<Integer> weightSet = new HashSet<>();
        weightSet.add(0);
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                List<Integer> weightList = new ArrayList<>(weightSet);
                for (Integer weight : weightList) {
                    weightSet.add(weight + weights[i]);
                }
            }
        }
        return weightSet.size();
    }

}
