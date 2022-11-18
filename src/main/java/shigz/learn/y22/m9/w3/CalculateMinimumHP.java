package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/23
 */
public class CalculateMinimumHP {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length - 1;
        int n = dungeon[0].length - 1;
        dungeon[m][n] = 1 - dungeon[m][n] > 0 ? 1 - dungeon[m][n] : 1;
        for (int k = n - 1; k >= 0; k--) {
            dungeon[m][k] = dungeon[m][k + 1] - dungeon[m][k] > 0 ? dungeon[m][k + 1] - dungeon[m][k] : 1;
        }
        for (int k = m - 1; k >= 0; k--) {
            dungeon[k][n] = dungeon[k + 1][n] - dungeon[k][n] > 0 ? dungeon[k + 1][n] - dungeon[k][n] : 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j =  n- 1; j >= 0; j--) {
                dungeon[i][j] = Math.min(dungeon[i + 1][j],dungeon[i][j + 1]) - dungeon[i][j];
                if (dungeon[i][j] <= 0) {
                    dungeon[i][j] = 1;
                }
            }
        }
        return dungeon[0][0];
    }

}
