package shigz.learn.y22.m10.w3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/10/17
 */
public class SummaryRanges {

    List<int[]> rangeList = new ArrayList<>();

    public SummaryRanges() {

    }

    public void addNum(int value) {
        if (0 == rangeList.size()) {
            rangeList.add(new int[]{value, value});
        } else {
            int left = -1;
            int right = rangeList.size() - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                int[] midRange = rangeList.get(mid);
                if (midRange[0] < value) {
                    left = mid;
                } else if (midRange[0] > value) {
                    right = mid - 1;
                } else return;
            }
            if (left == -1) {
                if (value == rangeList.get(0)[0] - 1) {
                    rangeList.get(0)[0] = value;
                } else {
                    rangeList.add(0, new int[]{value, value});
                }
            } else {
                int[] leftRange = rangeList.get(left);
                if (value > leftRange[1]) {
                    if (value == leftRange[1] + 1) {
                        if (left + 1 < rangeList.size() && value == rangeList.get(left + 1)[0] - 1) {
                            leftRange[1] = rangeList.get(left + 1)[1];
                            rangeList.remove(left + 1);
                        } else {
                            rangeList.get(left)[1] = value;
                        }
                    } else {
                        if (left + 1 < rangeList.size() && value == rangeList.get(left + 1)[0] - 1) {
                            rangeList.get(left + 1)[0] = value;
                        } else {
                            rangeList.add(left + 1, new int[]{value, value});
                        }
                    }
                }
            }
        }

    }

    public int[][] getIntervals() {
        return rangeList.toArray(new int[0][0]);
    }

}
