package shigz.learn.y22.m9.w3;

import shigz.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (currentNode == currentNode.next) return true;
            ListNode secondNode = head;
            while (secondNode != currentNode) {
                if (secondNode == currentNode.next) return true;
                secondNode = secondNode.next;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    //非常量内存
    public boolean firstTry(ListNode head) {
        if (head == null) return false;
        List<ListNode> nodeList = new ArrayList<>();
        ListNode currentNode = head;
        while (currentNode.next != null) {
            for (ListNode node : nodeList) {
                if (currentNode.next == node) return true;
            }
            nodeList.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }

}
