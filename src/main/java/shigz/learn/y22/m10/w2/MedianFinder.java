package shigz.learn.y22.m10.w2;

import java.util.LinkedList;

/**
 * Created by 大史 on 2022/10/9
 */
public class MedianFinder {

    LinkedList<Integer> numList = new LinkedList<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (0 == numList.size() || numList.get(numList.size() - 1) <= num) {
            numList.add(num);
        } else {
            int left = 0;
            int right = numList.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numList.get(mid) < num) {
                    left = mid + 1;
                } else if (numList.get(mid) == num) {
                    right = mid - 1;
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            numList.add(left,num);
        }

    }

    public double findMedian() {
        int mid = numList.size() / 2;
        if (mid * 2 == numList.size()) {
            return (numList.get(mid) + numList.get(mid - 1)) / 2.0;
        } else {
            return numList.get(mid);
        }
    }

}
