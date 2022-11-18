package shigz.learn.y22.m10.w3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/10/21
 */
public class StockSpanner {

    private final List<int[]> numCountArrList = new ArrayList<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int index = numCountArrList.size() - 1;
        int count = 1;
        while (index >= 0) {
            int[] numCountArr = numCountArrList.get(index);
            if (numCountArr[0] > price) {
                break;
            } else {
                count += numCountArr[1];
                index -= numCountArr[1];
            }
        }
        numCountArrList.add(new int[]{price,count});
        return count;
    }

}
