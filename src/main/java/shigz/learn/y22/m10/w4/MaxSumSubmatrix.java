package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/31
 */
public class MaxSumSubmatrix {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        //存储坐标对应的前缀和
        int[][] dp = new int[m + 1][n + 1];
        //结果值,记录最贴近目标值的前缀和
        int result = -100001;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当前前缀和为当前元素加上向上和向左两个前缀和并减去重复的前缀和
                dp[i + 1][j + 1] = matrix[i][j] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
                //判断当前前缀和是否更贴近目标值,如果结果为目标值,返回目标值,如果比结果值更贴近目标值,更新结果值
                if (dp[i + 1][j + 1] == k) return k;
                if (dp[i + 1][j + 1] < k && dp[i + 1][j + 1] > result) result = dp[i + 1][j + 1];
                //遍历行和列,逐行减掉前缀和,寻找更贴近目标值的矩阵和
                for (int i1 = 0;i1 <= i;i1++) {
                    for (int j1 = 0;j1 <= j;j1 ++) {
                        int sum = dp[i + 1][j+ 1] - dp[i1][j + 1] - dp[i + 1][j1] + dp[i1][j1];
                        if (sum == k) return k;
                        if (sum < k && sum > result) result = sum;
                    }
                }
            }
        }
        return result;
    }

}
