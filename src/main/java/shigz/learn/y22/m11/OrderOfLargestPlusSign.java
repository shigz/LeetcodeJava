package shigz.learn.y22.m11;

import java.util.*;

/**
 * Created by 大史 on 2022/11/9
 */
public class OrderOfLargestPlusSign {

    //动态规划
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> bannedSet = new HashSet<>();
        //将为 0 的节点加入到 HashSet 中,便于查找 将 x 和 y 索引转换为一维
        for (int[] mine : mines) {
            bannedSet.add(mine[0] * n + mine[1]);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int offset = i * n;
            //先计算向左有几个 1 ,并将每个节点的向左有几个 1 进行记录
            for (int j = 0; j < n; j++) {
                if (bannedSet.contains(offset + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            //计算向右有几个 1,并将每个节点的值取向左和向右之间的最小值
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (bannedSet.contains(offset + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0;i < n;i++) {
            //计算向上有几个 1,并取每个节点当前的最小值
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (bannedSet.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            //计算向下有几个 1,并取每个节点当前的最小值
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (bannedSet.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                //取最终结果的最大值
                res = Math.max(res, dp[j][i]);
            }
        }
        return res;
    }

    //超时了,耗时过久
    public int firstTry(int n, int[][] mines) {
        Map<Integer, Set<Integer>> mineMap = new HashMap<>();
        //将为 0 的节点加入到 Hash 表中,便于查找
        for (int[] mine : mines) {
            if (mineMap.containsKey(mine[0])) {
                mineMap.get(mine[0]).add(mine[1]);
            } else {
                Set<Integer> ySet = new HashSet<>();
                ySet.add(mine[1]);
                mineMap.put(mine[0], ySet);
            }
        }

        int res = (n - 1) / 2;
        while (res >= 0) {
            for (int i = res; i < n - res; i++) {
                for (int j = res; j < n - res; j++) {
                    if (isValid(i, j, mineMap, res)) return res + 1;
                }
            }
            res--;
        }
        return 0;
    }

    private boolean isValid(int i, int j, Map<Integer, Set<Integer>> mineMap, int res) {
        if (mineMap.containsKey(i)) {
            if (mineMap.get(i).contains(j)) return false;
            for (int j1 = j - res; j1 < j; j1++) {
                if (mineMap.get(i).contains(j1)) return false;
            }
            for (int j1 = j + 1; j1 <= j + res; j1++) {
                if (mineMap.get(i).contains(j1)) return false;
            }
        }
        for (int i1 = i - res; i1 < i; i1++) {
            if (mineMap.containsKey(i1) && mineMap.get(i1).contains(j)) return false;
        }
        for (int i1 = i + 1; i1 <= i + res; i1++) {
            if (mineMap.containsKey(i1) && mineMap.get(i1).contains(j)) return false;
        }
        return true;
    }

}
