package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/22
 */
public class MinStack {

    Node numNode = new Node(null);
    Node sortNumNode = new Node(null);

    public MinStack() {

    }

    public void push(int val) {
        Node current = new Node(val);
        Node currentNode = sortNumNode;
        while (currentNode.next !=null && currentNode.next.val < val) {
            currentNode = currentNode.next;
        }
        if (currentNode.val != null && currentNode.val == val) {
            currentNode.count += 1;
        } else {
            Node currentSortNode = new Node(val);
            currentSortNode.next = currentNode.next;
            currentNode.next = currentSortNode;
        }
        current.next = numNode.next;
        numNode.next = current;
    }

    public void pop() {
        int val = numNode.next.val;
        Node currentNode = sortNumNode;
        while (currentNode.next.val != val) {
            currentNode = currentNode.next;
        }
        if (currentNode.next.count > 1) {
            currentNode.next.count = currentNode.next.count - 1;
        } else {
            currentNode.next = currentNode.next.next;
        }
        numNode.next = numNode.next.next;
    }

    public int top() {
        return numNode.next.val;
    }

    public int getMin() {
        return sortNumNode.next.val;
    }

    static class Node {
        Integer val;
        int count = 1;
        Node next;

        Node(Integer x) {
            val = x;
            next = null;
        }
    }

}
