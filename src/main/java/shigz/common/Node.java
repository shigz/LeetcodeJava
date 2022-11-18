package shigz.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/20
 */
public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public Node(int[][] numArr) {
        val = 1;
        neighbors = new ArrayList<>();
        Node[] nodeArr = new Node[numArr.length];
        nodeArr[0] = this;
        for (int i = 2; i <= numArr.length; i++) {
            nodeArr[i - 1] = new Node(i);
        }
        for (int i = 0; i < numArr.length; i++) {
            int[] neighborArr = numArr[i];
            for (int neighbor:neighborArr) {
                nodeArr[i].neighbors.add(nodeArr[neighbor - 1]);
            }
        }
    }

}
