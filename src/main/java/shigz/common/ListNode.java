package shigz.common;

/**
 * Created by 大史 on 2022/9/21
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int[] valArr, int pos) {
        if (0 < valArr.length) {
            this.val = valArr[0];
            ListNode[] nodeArr = new ListNode[valArr.length];
            nodeArr[0] = this;
            for (int i = 1; i < valArr.length; i++) {
                ListNode currentNode = new ListNode(valArr[i]);
                nodeArr[i - 1].next = currentNode;
                nodeArr[i] = currentNode;
            }
            if (0 <= pos && pos < nodeArr.length) {
                nodeArr[nodeArr.length - 1].next = nodeArr[pos];
            }
        }
    }

    public ListNode(int[] valArr) {
        if (0 < valArr.length) {
            this.val = valArr[0];
            ListNode[] nodeArr = new ListNode[valArr.length];
            nodeArr[0] = this;
            for (int i = 1; i < valArr.length; i++) {
                ListNode currentNode = new ListNode(valArr[i]);
                nodeArr[i - 1].next = currentNode;
                nodeArr[i] = currentNode;
            }
        }
    }

}
