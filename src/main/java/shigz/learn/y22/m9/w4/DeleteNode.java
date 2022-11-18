package shigz.learn.y22.m9.w4;

import shigz.common.ListNode;

/**
 * Created by 大史 on 2022/9/30
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        ListNode currentNode = node;
        while (currentNode.next.next != null) {
            currentNode.val = currentNode.next.val;
            currentNode = currentNode.next;
        }
        currentNode.val = currentNode.next.val;
        currentNode.next = null;
    }

}
