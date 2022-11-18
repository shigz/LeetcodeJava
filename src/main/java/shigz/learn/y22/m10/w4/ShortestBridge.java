package shigz.learn.y22.m10.w4;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by 大史 on 2022/10/25
 */
public class ShortestBridge {

    int m;
    int n;

    int[][] offsetMatrix = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    };
    Queue<int[]> queue = new ArrayDeque<>();

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        split(grid);
        int step = 0;
        while (0 < queue.size()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                int i = node[0];
                int j = node[1];
                for (int[] offset:offsetMatrix) {
                    int subI = i + offset[0];
                    int subJ = j + offset[1];
                    if (subI >= 0 && subJ >= 0 && subI < m && subJ < n) {
                        if (grid[subI][subJ] == 0) {
                            queue.offer(new int[]{subI,subJ});
                            grid[subI][subJ] = -1;
                        } else if (grid[subI][subJ] == 1) return step;
                    }
                }
            }
            step++;
        }
        return step;
    }

    private void split(int[][] grid) {
        int i = 0;
        int j = 0;
        while (grid[i][j] != 1) {
            if (j == n - 1) {
                if (i == n - 1) break;
                i++;
                j = 0;
            } else j++;
        }
        colour(grid, i, j);
    }

    private void colour(int[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n) {
            if (grid[i][j] == 1) {
                queue.offer(new int[]{i, j});
                grid[i][j] = -1;
                for (int[] offset : offsetMatrix) {
                    colour(grid, i + offset[0], j + offset[1]);
                }
            }
        }
    }
}