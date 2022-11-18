package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/21
 */
public class SolveSudoku {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = in.nextInt();
            }
        }
        solveSudoku(sudoku, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(sudoku[i][0]);
            for (int j = 1; j < 9; j++) {
                sb.append(' ').append(sudoku[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static boolean solveSudoku(int[][] sudoku, int x, int y) {
        if (x < 9) {
            if (sudoku[x][y] == 0) {
                for (int i = 1; i <= 9; i++) {
                    if (isValidNum(sudoku, x, y, i)) {
                        sudoku[x][y] = i;
                        if (solveSudokuBy(sudoku, x, y)) return true;
                    }
                }
                sudoku[x][y] = 0;
                return false;
            } else {
                return solveSudokuBy(sudoku, x, y);
            }
        } else {
            return true;
        }
    }

    private static boolean isValidNum(int[][] sudoku, int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (i != x && sudoku[i][y] == num) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i != y && sudoku[x][i] == num) return false;
        }
        int startX = x - x % 3;
        int startY = y - y % 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if ((i != x || j != y) && sudoku[i][y] == num) return false;
            }
        }
        return true;
    }

    private static boolean solveSudokuBy(int[][] sudoku, int x, int y) {
        if (y == 8) {
            return solveSudoku(sudoku, x + 1, 0);
        } else {
            return solveSudoku(sudoku, x, y + 1);
        }
    }

}
