package shigz.learn.y22.m9.w4;

import shigz.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 大史 on 2022/9/30
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Deque<Integer> smallestQueue = kSmallest(root, k);
        if (smallestQueue.size() >= k) {
            return smallestQueue.pollLast();
        } else return 0;
    }

    public Deque<Integer> kSmallest(TreeNode node, int k) {
        Deque<Integer> resultQueue = new LinkedList<>();
        if (node != null) {
            Deque<Integer> leftQueue = kSmallest(node.left, k);
            Deque<Integer> rightQueue = kSmallest(node.right, k);
            boolean flag = false;
            while (resultQueue.size() < k) {
                if (!flag) {
                    if (leftQueue.isEmpty()) {
                        if (rightQueue.isEmpty()) {
                            resultQueue.add(node.val);
                            flag = true;
                        } else {
                            if (rightQueue.peekFirst() > node.val) {
                                resultQueue.add(node.val);
                                flag = true;
                            } else {
                                resultQueue.add(rightQueue.pollFirst());
                            }
                        }
                    } else {
                        if (rightQueue.isEmpty()) {
                            if (leftQueue.peekFirst() > node.val) {
                                resultQueue.add(node.val);
                                flag = true;
                            } else {
                                resultQueue.add(leftQueue.pollFirst());
                            }
                        } else {
                            if (leftQueue.peekFirst() > node.val) {
                                if (rightQueue.peekFirst() > node.val) {
                                    resultQueue.add(node.val);
                                    flag = true;
                                } else {
                                    resultQueue.add(rightQueue.pollFirst());
                                }
                            } else {
                                if (rightQueue.peekFirst() > leftQueue.peekFirst()) {
                                    resultQueue.add(leftQueue.pollFirst());
                                } else {
                                    resultQueue.add(rightQueue.pollFirst());
                                }
                            }
                        }
                    }
                } else {
                    if (leftQueue.isEmpty()) {
                        if (rightQueue.isEmpty()) {
                            break;
                        } else {
                            resultQueue.add(rightQueue.pollFirst());
                        }
                    } else {
                        if (rightQueue.isEmpty()) {
                            resultQueue.add(leftQueue.pollFirst());
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return resultQueue;
    }

}
