package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/25
 */
public class MatrixMul {

    private static int m;
    private static int n;
    private static int k;

    private static int[][] resultMatrix;

    public static void main(String[] args) {
        m = 2;
        n = 3;
        k = 2;
        resultMatrix = new int[m][k];
        int[][] leftMatrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 2, 1}
        };
        int[][] rightMatrix = new int[][]{
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{3, 3}
        };
        mul(leftMatrix, rightMatrix);
    }

    private static void mul(int[][] leftMatrix, int[][] rightMatrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int l = 0; l < k; l++) {
                int temp = 0;
                for (int j = 0; j < n; j++) {
                    temp += leftMatrix[i][j] * rightMatrix[j][l];
                }
                sb.append(temp).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
