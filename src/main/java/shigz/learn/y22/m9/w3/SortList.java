package shigz.learn.y22.m9.w3;

import shigz.common.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 大史 on 2022/9/21
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        Queue<ListNode> nodeQueue = new LinkedList<>();
        ListNode current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = null;
            nodeQueue.add(current);
            current = temp;
        }

        while (0 < nodeQueue.size()) {
            current = nodeQueue.poll();
            temp = nodeQueue.poll();
            ListNode resultNode = merge(current, temp);
            if (0 < nodeQueue.size()) {
                nodeQueue.add(resultNode);
            } else {
                return resultNode;
            }
        }
        return null;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(-1);
        ListNode currentNode1 = node1;
        ListNode currentNode2 = node2;
        ListNode current = result;
        ListNode temp;
        while (currentNode1 != null && currentNode2 != null) {
            if (currentNode1.val < currentNode2.val) {
                temp = currentNode1.next;
                currentNode1.next = null;
                current.next = currentNode1;
                currentNode1 = temp;
            } else {
                temp = currentNode2.next;
                currentNode2.next = null;
                current.next = currentNode2;
                currentNode2 = temp;
            }
            current = current.next;
        }
        if (currentNode1 != null) {
            current.next = currentNode1;
        } else {
            if (currentNode2 != null) {
                current.next = currentNode2;
            }
        }
        return result.next;
    }

    public ListNode firstTry(ListNode head) {
        if (head == null) return null;
        ListNode result = new ListNode(-1);
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode temp = currentNode.next;
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
