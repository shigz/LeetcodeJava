package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/10
 */
public class MinSwap {
    public int minSwap(int[] nums1, int[] nums2) {
        int left = 0;
        int right = 1;
        int index = 1;
        while (index < nums1.length) {
            int tempLeft = left;
            int tempRight = right;
            if (nums1[index - 1] >= nums1[index] || nums2[index - 1] >= nums2[index]) {
                left = tempRight;
                right = tempLeft + 1;
            } else {
                right = tempRight + 1;
                if (nums1[index - 1] < nums2[index] && nums2[index - 1] < nums1[index]) {
                    left = Math.min(left,tempRight);
                    right = Math.min(right,tempLeft + 1);
                }
            }
            index++;
        }

        return Math.min(left,right);
    }
}
