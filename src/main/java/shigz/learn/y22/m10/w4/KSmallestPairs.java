package shigz.learn.y22.m10.w4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 大史 on 2022/10/31
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int min = Integer.MIN_VALUE;
        while (resultList.size() < k) {
            resultList.add(Arrays.asList(nums1[index1], nums2[index2]));
            min = nums1[index1] + nums2[index2];
            int temp = index2 + 1;
            if (index1 < nums1.length - 1) {
                if (index2 < nums2.length - 1) {
                    //比较移动数组 1 的坐标和移动数组 2 的坐标后的首坐标和大小,按和小的移动
                    if (nums1[index1] + nums2[index2 + 1] < nums1[index1 + 1] + nums2[index2]) {
                        index2++;
                    } else index1++;
                } else {
                    //如果 index2 已经移动完,直接移动 index1
                    index1++;
                }
            } else {
                if (index2 < nums2.length - 1) {
                    //如果 index1 已经移动完,直接移动 index2
                    index2++;
                } else {
                    //index1 和 index2 一定结束,退出
                    break;
                }

            }
        }
        return resultList;
    }

}
