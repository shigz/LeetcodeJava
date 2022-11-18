package shigz.learn.y22.m9.w3;

import shigz.common.random.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        List<Node> nodeList = new ArrayList<>();
        List<Node> cloneNodeList = new ArrayList<>();
        Node currentNode = head;
        while (currentNode != null) {
            Node currentCloneNode = new Node(currentNode.val);
            if (currentNode.random != null) {
                for (int i = 0; i < nodeList.size(); i++) {
                    if (currentNode.random == nodeList.get(i)) {
                        currentCloneNode.random = cloneNodeList.get(i);
                        break;
                    }
                }
            }
            nodeList.add(currentNode);
            cloneNodeList.add(currentCloneNode);
            currentNode = currentNode.next;
        }
        for (int i = 0; i < cloneNodeList.size(); i++) {
            Node currentCloneNode = cloneNodeList.get(i);
            if (i < cloneNodeList.size() - 1) {
                currentCloneNode.next = cloneNodeList.get(i + 1);
            }
            if (currentCloneNode.random == null && nodeList.get(i).random != null) {
                for (int k = i; k < nodeList.size(); k++) {
                    if (nodeList.get(i).random == nodeList.get(k)) {
                        currentCloneNode.random = cloneNodeList.get(k);
                        break;
                    }
                }
            }
        }

        return cloneNodeList.get(0);
    }

}
