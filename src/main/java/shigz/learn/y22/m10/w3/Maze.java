package shigz.learn.y22.m10.w3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/21
 */
public class Maze {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i< m ;i++) {
            for (int j = 0;j < n;j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        List<int[]> pointList = new ArrayList<>();
        solveMaze(matrix, 0, 0, m, n, pointList);
        for (int[] point : pointList) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }
    }

    private static final int[][] offsetMatrix = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    };

    private static boolean solveMaze(int[][] matrix, int x, int y, int m, int n, List<int[]> pointList) {
        if (x == m - 1 && y == n - 1) {
            pointList.add(new int[]{x, y});
            return true;
        }
        if (x < 0 || y < 0 || x >= m || y >= n) return false;
        if (matrix[x][y] != 0) return false;
        matrix[x][y] = 2;
        pointList.add(new int[]{x, y});
        for (int[] offset : offsetMatrix) {
            if (solveMaze(matrix, x + offset[0], y + offset[1], m, n, pointList)) return true;
        }
        matrix[x][y] = 0;
        pointList.remove(pointList.size() - 1);
        return false;
    }

}
