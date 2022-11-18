package shigz.learn.y22.m10.w3;

import java.util.Arrays;

/**
 * Created by 大史 on 2022/10/24
 */
public class MinK {

    public static void main(String[] args) {
        int[] numArr = new int[]{1, 3, 5, 7, 2};
        int[] sortedArr = new int[5];
        Arrays.fill(sortedArr, Integer.MAX_VALUE);
        for (int j : numArr) {
            addNumber(sortedArr, j);
        }
        System.out.println();
    }

    private static int[] sort(int[] numArr, int k) {
        int[] resultArr = new int[k];
        Arrays.fill(resultArr, Integer.MAX_VALUE);
        for (int i = 0; i < numArr.length; i++) {
            int num = numArr[i];
            int cur = k;
            if (resultArr[cur - 1] > num) {
                cur--;
                while (cur > 0 && resultArr[cur - 1] > num) {
                    resultArr[cur] = resultArr[cur - 1];
                    cur--;
                }
                resultArr[cur] = num;
            }
        }
        return resultArr;
    }

    private static void addNumber(int[] sortedArr, int num) {
        int cur = sortedArr.length - 1;
        if (sortedArr[cur] > num) {
            while (cur > 0 && sortedArr[cur - 1] > num) {
                sortedArr[cur] = sortedArr[cur - 1];
                cur--;
            }
            sortedArr[cur] = num;
        }
    }

}
