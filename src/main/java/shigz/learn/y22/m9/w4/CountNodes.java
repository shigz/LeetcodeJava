package shigz.learn.y22.m9.w4;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/9/29
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return countOf(root);
    }

    private int countOf(TreeNode node) {
        if (node.left != null) {
            if (node.right != null) {
                int leftCount = countNodes(node.left);
                int rightCount = countNodes(node.right);
                return leftCount + rightCount + 1;
            } else {
                return 2;
            }
        } else {
            return 1;
        }
    }

}
