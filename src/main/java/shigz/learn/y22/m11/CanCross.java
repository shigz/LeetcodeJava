package shigz.learn.y22.m11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 大史 on 2022/11/3
 */
public class CanCross {

    public boolean canCross(int[] stones) {
        List<Set<Integer>> jumpStepSetList = new ArrayList<>();
        Set<Integer> firstJumpStepSet = new HashSet<>();
        firstJumpStepSet.add(1);
        jumpStepSetList.add(firstJumpStepSet);
        for (int i = 1; i < stones.length; i++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int j = 0;j < jumpStepSetList.size();j++) {
                int step = stones[i] - stones[j];
                if (j >= step && jumpStepSetList.get(j).contains(step)) {
                    if (step > 1) {
                        currentSet.add(step - 1);
                    }
                    currentSet.add(step);
                    currentSet.add(step + 1);
                }
            }
            jumpStepSetList.add(currentSet);
        }
        return !jumpStepSetList.get(jumpStepSetList.size() - 1).isEmpty();
    }

}
