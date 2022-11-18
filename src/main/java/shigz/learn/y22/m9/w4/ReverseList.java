package shigz.learn.y22.m9.w4;

import shigz.common.ListNode;
import shigz.common.Node;

/**
 * Created by 大史 on 2022/9/27
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        return iterate(head);
    }

    private ListNode recursion(ListNode node) {
        if (node.next != null) {
            ListNode result = recursion(node.next);
            node.next = null;
            ListNode lastNode = result;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = node;
            return result;
        } return node;
    }

    private ListNode iterate(ListNode head) {
        ListNode currentNode = head;
        ListNode resultNode = null;
        while (currentNode != null) {
            ListNode temp = currentNode.next;
            currentNode.next = resultNode;
            resultNode = currentNode;
            currentNode = temp;
        }
        return resultNode;
    }

}
