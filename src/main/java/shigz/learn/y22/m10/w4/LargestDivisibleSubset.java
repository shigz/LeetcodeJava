package shigz.learn.y22.m10.w4;

import java.util.*;

/**
 * Created by 大史 on 2022/10/31
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        //存储子序列长度和当前数据列表
        Map<Integer, List<Node>> nodeListMap = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int current = max;
            Node currentNode = new Node(num);
            while (current > 0) {
                Node nextNode = getNode(num, nodeListMap.get(current));
                if (nextNode != null) {
                    currentNode.next = nextNode;
                    break;
                }
                current--;
            }
            if (nodeListMap.containsKey(current + 1)) {
                nodeListMap.get(current + 1).add(currentNode);
            } else {
                List<Node> nodeList = new ArrayList<>();
                nodeList.add(currentNode);
                nodeListMap.put(current + 1, nodeList);
                max = current + 1;
            }
        }
        Node maxNode = nodeListMap.get(max).get(0);
        List<Integer> resultList = new ArrayList<>();
        while (maxNode != null) {
            resultList.add(0,maxNode.val);
            maxNode = maxNode.next;
        }
        return resultList;
    }

    private Node getNode(int num, List<Node> nodeList) {
        for (Node node : nodeList) {
            if (num % node.val == 0) return node;
        }
        return null;
    }

    static class Node {

        Node next;
        int val;

        public Node(int num) {
            this.val = num;
        }

    }

}
