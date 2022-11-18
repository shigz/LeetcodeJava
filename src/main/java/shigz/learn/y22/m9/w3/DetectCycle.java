package shigz.learn.y22.m9.w3;

import shigz.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode firstTry(ListNode head) {
        if (head == null) return null;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (currentNode == currentNode.next) return currentNode;
            ListNode secondNode = head;
            while (secondNode != currentNode) {
                if (secondNode == currentNode.next) return secondNode;
                secondNode = secondNode.next;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

}
