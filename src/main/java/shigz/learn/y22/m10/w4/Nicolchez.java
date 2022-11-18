package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/26
 */
public class Nicolchez {

    public static void main(String[] args) {
        dealOdd(1);
        dealOdd(3);
        dealEven(4);
        dealOdd(5);
        dealEven(6);
    }

    // 奇数
    // 向前加 n/2 个奇数
    // 加 奇数的平方
    // 向后加 n/2 个奇数
    private static void dealOdd(int n) {
        StringBuilder sb = new StringBuilder();
        int square = n * n;
        for (int i = square - n + 1; i < square; i += 2) {
            if (0 < sb.length()) sb.append("+");
            sb.append(i);
        }
        if (0 < sb.length()) sb.append("+");
        sb.append(square);
        for (int i = square + 2; i <= square + n - 1; i += 2) {
            sb.append("+");
            sb.append(i);
        }
        System.out.println(sb);
    }

    // 奇数
    // 向前加 n/ 2 个奇数
    // 向后加 n/ 2 个奇数
    private static void dealEven(int n) {
        StringBuilder sb = new StringBuilder();
        int square = n * n;
        for (int i = square - n + 1; i < square; i += 2) {
            if (0 < sb.length()) sb.append("+");
            sb.append(i);
        }
        for (int i = square + 1; i < square + n; i += 2) {
            sb.append("+");
            sb.append(i);
        }
        System.out.println(sb);
    }

}
