package shigz.common.random;

/**
 * Created by 大史 on 2022/9/21
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(Integer[][] numArr) {
        if (0 < numArr.length) {
            this.val = numArr[0][0];
            if (1 < numArr.length) {
                Node[] nodeArr = new Node[numArr.length];
                nodeArr[numArr.length - 1] = new Node(numArr[numArr.length - 1][0]);
                for (int i = numArr.length - 2; i > 0; i--) {
                    nodeArr[i] = new Node(numArr[i][0]);
                    nodeArr[i].next = nodeArr[i + 1];
                }
                nodeArr[0] = this;
                this.next = nodeArr[1];
                for (int i = 1; i < numArr.length; i++) {
                    if (numArr[i][1] != null) {
                        nodeArr[i].random = nodeArr[numArr[i][1]];
                    }
                }
            }

        }

    }

}
