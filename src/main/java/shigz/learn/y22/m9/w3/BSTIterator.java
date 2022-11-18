package shigz.learn.y22.m9.w3;

import shigz.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/23
 */
public class BSTIterator {

    List<Integer> numList = new ArrayList<>();
    int currentIndex = 0;

    public BSTIterator(TreeNode root) {
        initNode(root);
    }

    private void initNode(TreeNode node) {
        if (node != null) {
            initNode(node.left);
            numList.add(node.val);
            initNode(node.right);
        }
    }

    public int next() {
        int result = numList.get(currentIndex);
        currentIndex++;
        return result;
    }

    public boolean hasNext() {
        return currentIndex < numList.size();
    }

}
