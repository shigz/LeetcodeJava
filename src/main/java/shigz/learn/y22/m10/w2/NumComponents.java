package shigz.learn.y22.m10.w2;

import shigz.common.ListNode;

/**
 * Created by 大史 on 2022/10/12
 */
public class NumComponents {

    public int numComponents(ListNode head, int[] nums) {
        boolean[] hasNumArr = new boolean[10001];
        for (int num : nums) {
            hasNumArr[num] = true;
        }
        ListNode cur = head;
        int result = 0;
        boolean flag = false;
        while (cur != null) {
            if (flag) {
                if (!hasNumArr[cur.val]) {
                    result++;
                    flag = false;
                }
            } else {
                if (hasNumArr[cur.val]) {
                    flag = true;
                }
            }
            cur = cur.next;
        }
        if (flag) result++;
        return result;
    }

}
