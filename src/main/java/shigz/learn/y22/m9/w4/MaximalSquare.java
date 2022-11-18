package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/29
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] maxMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                maxMatrix[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                maxMatrix[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int current = 1;
                    boolean flag = true;
                    while (flag && current <= maxMatrix[i - 1][j - 1]) {
                        if (matrix[i - current][j] == '0' || matrix[i][j - current] == '0') {
                            flag = false;
                        } else {
                            current++;
                        }
                    }
                    max = Math.max(max,current);
                    maxMatrix[i][j] = current;
                }
            }
        }
        return max * max;
    }

}
