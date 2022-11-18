package shigz.learn.y22.m10.w3;

import shigz.common.BaseObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 大史 on 2022/10/17
 */
public class EmptyBottle extends BaseObject {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (str != null && !str.equals("0")) {
            if (str != null && 0 < str.trim().length()) {
                System.out.println(getCount(Integer.parseInt(str)));
            }
            str = br.readLine();
        }

    }

    private static int getCount(int num) {
        int result = 0;
        while (num > 2) {
            result += num / 3;
            num = num / 3 + num % 3;
        }
        if (num == 2) result++;
        return result;
    }

}
