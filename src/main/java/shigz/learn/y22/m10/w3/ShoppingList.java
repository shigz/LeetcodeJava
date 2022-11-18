package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/19
 */
public class ShoppingList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt() / 10;
        int count = in.nextInt();
        in.nextLine();
        int[][] priceImportanceMatrix = new int[count][8];
        int index = 0;
        while (index < count) {
            int v = in.nextInt() / 10;
            int p = in.nextInt();
            int q = in.nextInt();
            if (q == 0) {
                priceImportanceMatrix[index][0] = v;
                priceImportanceMatrix[index][1] = v * p;
            } else {
                if (priceImportanceMatrix[q - 1][2] == 0) {
                    priceImportanceMatrix[q - 1][2] = v;
                    priceImportanceMatrix[q - 1][3] = v * p;
                } else {
                    priceImportanceMatrix[q - 1][4] = v;
                    priceImportanceMatrix[q - 1][5] = v * p;
                }
            }
            in.nextLine();
            index++;
        }

        int[] maxImportantArr = new int[money + 1];
        for (int[] priceImportanceArr : priceImportanceMatrix) {
            if (priceImportanceArr[2] != 0) {
                priceImportanceArr[2] += priceImportanceArr[0];
                priceImportanceArr[3] += priceImportanceArr[1];
                if (priceImportanceArr[4] != 0) {
                    priceImportanceArr[4] += priceImportanceArr[0];
                    priceImportanceArr[5] += priceImportanceArr[1];
                    priceImportanceArr[6] += priceImportanceArr[2] + priceImportanceArr[4] - priceImportanceArr[0];
                    priceImportanceArr[7] += priceImportanceArr[3] + priceImportanceArr[5] - priceImportanceArr[1];
                }
            }
            for (int j = money; j >= priceImportanceArr[0]; j--) {
                for (int i = 6; i >= 0; i -= 2) {
                    if (priceImportanceArr[i] != 0 && j >= priceImportanceArr[i]) {
                        maxImportantArr[j] = Math.max(maxImportantArr[j], maxImportantArr[j - priceImportanceArr[i]] + priceImportanceArr[i + 1]);
                    }
                }
            }
        }
        System.out.println(maxImportantArr[money] * 10);
    }

}

