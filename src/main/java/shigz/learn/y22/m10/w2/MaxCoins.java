package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/10
 */
public class MaxCoins {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] mulArr = new int[n + 2];
        mulArr[0] = 1;
        mulArr[n + 1] = 1;
        System.arraycopy(nums, 0, mulArr, 1, n);
        int[][] resMatrix = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    int temp = mulArr[i] * mulArr[j] * mulArr[k] + resMatrix[i][k] + resMatrix[k][j];
                    resMatrix[i][j] = Math.max(temp, resMatrix[i][j]);
                }
            }
        }

        return resMatrix[0][n + 1];
    }

}
