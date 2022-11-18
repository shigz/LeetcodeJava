package shigz.learn.y22.m9.w4;

import shigz.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 大史 on 2022/9/27
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<TreeNode> evenQueue = new LinkedList<>();
        Queue<TreeNode> oddQueue = new LinkedList<>();
        evenQueue.add(root);
        TreeNode currentNode = null;
        while (0 < evenQueue.size()) {
            while (0 < evenQueue.size()) {
                currentNode = evenQueue.poll();
                if (currentNode.left != null) oddQueue.add(currentNode.left);
                if (currentNode.right != null) oddQueue.add(currentNode.right);
            }
            resultList.add(currentNode.val);
            if (0 < oddQueue.size()) {
                while (0 < oddQueue.size()) {
                    currentNode = oddQueue.poll();
                    if (currentNode.left != null) evenQueue.add(currentNode.left);
                    if (currentNode.right != null) evenQueue.add(currentNode.right);
                }
                resultList.add(currentNode.val);
            }
        }

        return resultList;
    }

}
