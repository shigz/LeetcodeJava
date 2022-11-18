package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class MustSeven {

    public static void main(String[] args) {
        System.out.println(maxSeven(20));
    }

    private static int maxSeven(int num) {
        int result = 0;
        for (int i = 7; i <= num; i++) {
            if (i % 7 == 0 ||String.valueOf(i).contains("7")) result++;
        }
        return result;
    }

}
