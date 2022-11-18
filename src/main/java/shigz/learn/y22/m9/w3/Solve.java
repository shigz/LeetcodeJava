package shigz.learn.y22.m9.w3;

import java.util.Set;

/**
 * Created by 大史 on 2022/9/20
 */
public class Solve {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {

        if (2 < board.length && 2 < board[0].length) {
            int row = board.length;
            int col = board[0].length;
            for (int j = 0; j < col; j++) {
                // 第一行
                if (board[0][j] == 'O') dfs(0, j, board, row, col);
                // 最后一行
                if (board[row - 1][j] == 'O') dfs(row - 1, j, board, row, col);
            }

            for (int i = 0; i < row; i++) {
                // 第一列
                if (board[i][0] == 'O') dfs(i, 0, board, row, col);
                // 最后一列
                if (board[i][col - 1] == 'O') dfs(i, col - 1, board, row, col);
            }

            // 转变
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'B') board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(int i, int j, char[][] board, int row, int col) {
        board[i][j] = 'B';
        for (int[] dir : dirs) {
            int tmp_i = dir[0] + i;
            int tmp_j = dir[1] + j;
            if (tmp_i < 0 || tmp_i >= row || tmp_j < 0 || tmp_j >= col || board[tmp_i][tmp_j] != 'O') continue;
            dfs(tmp_i, tmp_j, board, row, col);
        }
    }

}
