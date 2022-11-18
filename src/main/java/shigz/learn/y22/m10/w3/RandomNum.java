package shigz.learn.y22.m10.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 大史 on 2022/10/17
 */
public class RandomNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> resultSet = new TreeSet<>();
        String line = br.readLine();
        int count = Integer.parseInt(line);
        while (0 < count) {
            line = br.readLine();
            resultSet.add(Integer.parseInt(line));
            count--;
        }
        for (Integer num : resultSet) {
            System.out.println(num);
        }
    }

}
