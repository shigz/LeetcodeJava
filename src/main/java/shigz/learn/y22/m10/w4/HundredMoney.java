package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/25
 */
public class HundredMoney {

    public static void main(String[] args) {
        deal();
    }

    //列方程 x + y + z = 100
    //5x + 3y + z/3 = 100
    //消元后可得 14x + 8y = 200
    //遍历 1 到 15,将所有乘以 14 后可以整除 8 的 x 找出来
    private static void deal() {
        int i = 0;
        while (i < 15) {
            if ((200 - i * 14) % 8 == 0) {
                System.out.print(i);
                System.out.print(" ");
                int j = (200 - i * 14) / 8;
                System.out.print(j);
                System.out.print(" ");
                System.out.print(100 - i - j);
                System.out.println();
            }
            i++;
        }
    }

}
