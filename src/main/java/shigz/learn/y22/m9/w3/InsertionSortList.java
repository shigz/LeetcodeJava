package shigz.learn.y22.m9.w3;

import shigz.common.ListNode;

/**
 * Created by 大史 on 2022/9/21
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode result = new ListNode(-1);
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode temp =  currentNode.next;
            ListNode currentResultNode = result;
            while (currentResultNode.next != null) {
                if (currentNode.val < currentResultNode.next.val) {
                    currentNode.next = currentResultNode.next;
                    currentResultNode.next = currentNode;
                    break;
                }
                currentResultNode = currentResultNode.next;
            }
            if (currentResultNode.next == null) {
                currentNode.next = null;
                currentResultNode.next = currentNode;
            }
            currentNode = temp;
        }
        return result.next;
    }

}
