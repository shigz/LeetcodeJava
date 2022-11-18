package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class TriangleYang {

    public static void main(String[] args) {
        int[] numArr = new int[40];
        for (int i = 1;i < 20;i ++) {
            int max = 2 * i - 1;
            int j = max - 1;
            numArr[j] = 1;
            j --;
            while (j >= 2) {
                numArr[j] = numArr[j] + numArr[j - 1] + numArr[j - 2];
                j--;
            }
            if (i > 1) numArr[1] = i - 1;
            for (int k = 0;k < max;k++) {
                System.out.print(numArr[k]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int getIndex(int num) {
        if (num <= 2) return -1;
        if (num % 2 == 1) return 2;
        if (num % 4 == 0) return 3;
        return 4;
    }

}
