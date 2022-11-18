package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/20
 */
public class Rabbits {

    public static void main(String[] args) {
        int n = 10;
        int pre = 1;
        int current = 1;
        int count = 2;
        while (count < n) {
            int temp = pre + current;
            pre = current;
            current = temp;
            count++;
        }
        System.out.println(current);
    }

}
