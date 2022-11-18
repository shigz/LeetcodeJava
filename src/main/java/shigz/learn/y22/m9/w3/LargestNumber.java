package shigz.learn.y22.m9.w3;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Arrays;

/**
 * Created by 大史 on 2022/9/23
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] text = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            text[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(text,(a,b) -> (a + b).compareTo(b + 1));
        if (text[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String word :text) {
            sb.append(word);
        }
        return sb.toString();
    }

}
