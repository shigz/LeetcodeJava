package shigz.learn.y22.m10.w4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 大史 on 2022/10/28
 */
public class GroupNumArr {

    public static void main(String[] args) {
        System.out.println(couldEqual(new int[]{1,5,-5,1}));
    }

    private static boolean couldEqual(int[] numArr) {
        //记录 3 和 5 的倍数之差
        int sum = 0;
        Set<Integer> otherSumSet = new HashSet<>();
        for (int num : numArr) {
            if (num % 5 == 0) {
                sum += num;
            } else if (num % 3 == 0) {
                sum -= num;
            } else {
                if (otherSumSet.isEmpty()) {
                    otherSumSet.add(num);
                    otherSumSet.add(-num);
                } else {
                    //分别记录当前数据加入到不同组的最终差值
                    List<Integer> preSumList = new ArrayList<>(otherSumSet);
                    otherSumSet.clear();
                    for (Integer preSum : preSumList) {
                        otherSumSet.add(preSum + num);
                        otherSumSet.add(preSum - num);
                    }
                }
            }
        }
        return (otherSumSet.isEmpty() && sum == 0) || otherSumSet.contains(sum);
    }

}
