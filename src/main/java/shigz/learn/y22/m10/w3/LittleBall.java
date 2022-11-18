package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/20
 */
public class LittleBall {

    public static void main(String[] args) {
        deal(1);
    }

    private static void deal(int n) {
        int count = 1;
        double sum = n;
        double value = n;
        while (count < 5) {
            sum += value;
            value = value / 2;
            count++;
        }
        System.out.println(sum);
        System.out.println(value / 2);
    }

}
