package shigz.learn.y22.m10.w2;

import java.util.Arrays;

/**
 * Created by 大史 on 2022/10/9
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;

    }

}
