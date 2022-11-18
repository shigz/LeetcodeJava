package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/27
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (0 <= r && 0 <= c && r < m && c < n && grid[r][c] == '1') {
            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
            dfs(grid, r + 1, c);
        }
    }

}
