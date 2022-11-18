package shigz.learn.y22.m10.w3;

import shigz.common.ListNode;

/**
 * Created by 大史 on 2022/10/17
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
               return true;
            }
        }
        return false;
    }

}
