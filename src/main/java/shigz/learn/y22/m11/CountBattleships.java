package shigz.learn.y22.m11;

/**
 * Created by 大史 on 2022/11/9
 */
public class CountBattleships {


    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果当前节点有战舰,则结果加 1
                if (dfs(i, j, board)) result++;
            }
        }
        return result;
    }

    private int m;
    private int n;
    private static final int[][] offsets = new int[][]{
            new int[]{0, -1},
            new int[]{0, 1},
            new int[]{-1, 0},
            new int[]{1, 0},
    };

    private boolean dfs(int x, int y, char[][] board) {
        if (x >= 0 && y >= 0 && x < m && y < n) {
            if (board[x][y] == 'X') {
                //当前节点为战舰 标记节点为已记录,并将相邻的其它同战舰节点标记为已记录
                board[x][y] = '0';
                for (int[] offset : offsets) {
                    dfs(x + offset[0], y + offset[1], board);
                }
                return true;
            }
        }
        return false;
    }

}
