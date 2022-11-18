package shigz.learn.y22.m10.w3;

import shigz.common.BaseObject;
import shigz.common.ListNode;

/**
 * Created by 大史 on 2022/10/17
 */
public class ReOrderList extends BaseObject {

    public static void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = new ListNode(-1);
        fast = slow.next;
        slow.next = null;
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = right.next;
            right.next = fast;
            fast = temp;
        }
        fast = right.next;
        slow = head;
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = null;
            fast.next = slow.next;
            slow.next = fast;
            slow = slow.next.next;
            fast = temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{});
        reorderList(head);
    }

}
