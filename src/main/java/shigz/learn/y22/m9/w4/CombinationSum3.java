package shigz.learn.y22.m9.w4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/28
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        combinationFrom(k, n, 1, new ArrayList<>(), resultList);
        return resultList;
    }

    private void combinationFrom(int k, int n, int start, List<Integer> preList, List<List<Integer>> resultList) {
        if (k == 1) {
            if (n >= start && n <= 9) {
                List<Integer> list = new ArrayList<>(preList);
                list.add(n);
                resultList.add(list);
            }
        } else {
            if (k <= 10 - start && (start + (k - 1) / 2) * k <= n) {
                combinationFrom(k,n,start + 1,preList,resultList);
                preList.add(start);
                combinationFrom(k - 1,n - start,start + 1,preList,resultList);
                preList.remove(preList.size() - 1);
            }
        }
    }

}
