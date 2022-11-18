package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/12
 */
public class LongestIncreasingPath {
    int m;
    int n;
    int[][] maxMatrix;

    int[][] offsets = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, 1},
            new int[]{0, -1},
    };

    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        m = matrix.length;
        n = matrix[0].length;
        maxMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maxMatrix[i][j] == 0) {
                    int maxCount = maxCountFrom(i, j, matrix, -1);
                    maxMatrix[i][j] = maxCount;
                }
                result = Math.max(result, maxMatrix[i][j]);
            }
        }
        return result;
    }

    private int maxCountFrom(int x, int y, int[][] matrix, int preValue) {
        if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= preValue) return 0;
        if (maxMatrix[x][y] > 0) return maxMatrix[x][y];
        int result = 1;
        for (int[] offset : offsets) {
            int maxCount = maxCountFrom(x + offset[0], y + offset[1], matrix, matrix[x][y]);
            if (maxCount > 0) {
                maxMatrix[x + offset[0]][y + offset[1]] = maxCount;
                result = Math.max(result, 1 + maxCount);
            }

        }
        return result;
    }

}
