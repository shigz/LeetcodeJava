package shigz.learn.y22.m9.w3;

import shigz.common.ListNode;

/**
 * Created by 大史 on 2022/9/23
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode resultNode = new ListNode(-1);
        resultNode.next = head;
        ListNode current = resultNode;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return resultNode.next;
    }

}
