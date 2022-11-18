package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/4
 */
public class TrapRainWater {

    private int m;
    private int n;

    public int trapRainWater(int[][] heightMap) {
        m = heightMap.length;
        n = heightMap[0].length;
        int result = 0;
        int max = 0;
        for (int[] heightArr : heightMap) {
            for (int height : heightArr) max = Math.max(max, height);
        }
        int height = 0;
        while (height < max) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = dfs(heightMap, height, i, j);
                    if (sum > 0) result += sum;
                }
            }
            height++;
        }
        return result;
    }

    public int dfs(int[][] heightMap, int height, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return -1;
        int newValue = -1 - height;
        if (heightMap[i][j] == newValue) return 0;
        if (heightMap[i][j] > height) return 0;
        heightMap[i][j] = newValue;
        int i1 = dfs(heightMap, height, i + 1, j);
        int i2 = dfs(heightMap, height, i - 1, j);
        int i3 = dfs(heightMap, height, i, j + 1);
        int i4 = dfs(heightMap, height, i, j - 1);
        if (i1 >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0) {
            return i1 + i2 + i3 + i4 + 1;
        } else return -1;
    }

}
