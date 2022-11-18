package shigz.learn.y22.m11;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/11/3
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root, true);
    }

    public int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node.left != null) {
            if (node.right != null) {
                return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
            } else {
                return sumOfLeftLeaves(node.left, true);
            }
        } else {
            if (node.right != null) {
                return sumOfLeftLeaves(node.right, false);
            } else {
                return isLeft ? node.val : 0;
            }
        }
    }

}
