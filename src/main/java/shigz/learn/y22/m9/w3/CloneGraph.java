package shigz.learn.y22.m9.w3;

import shigz.common.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大史 on 2022/9/20
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        cloneNode(node, nodeMap);
        return nodeMap.get(node.val);
    }

    private void cloneNode(Node node, Map<Integer, Node> nodeMap) {
        Node currentNode = new Node(node.val);
        nodeMap.put(node.val, currentNode);
        List<Node> neighborList = node.neighbors;
        for (Node neighbor : neighborList) {
            if (!nodeMap.containsKey(neighbor.val)) {
                cloneNode(neighbor, nodeMap);
            }
            Node cloneNeighbor = nodeMap.get(neighbor.val);
            currentNode.neighbors.add(cloneNeighbor);
        }
    }

}
