package shigz.learn.y22.m9.w3;

import shigz.common.ListNode;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class ReOrderList {

    public void reorderList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode headNode = head;
        ListNode current = headNode.next;
        while (current != null) {
            nodeList.add(current);
            current = current.next;
        }
        int count = 0;
        while (count < nodeList.size()) {
            if (count % 2 == 0) {
                headNode.next = nodeList.get(nodeList.size() - 1 - count / 2);
            } else {
                headNode.next = nodeList.get(count / 2);
            }
            headNode = headNode.next;
            count++;
        }
        headNode.next = null;
    }

}
