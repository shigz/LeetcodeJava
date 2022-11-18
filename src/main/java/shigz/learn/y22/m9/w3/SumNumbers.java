package shigz.learn.y22.m9.w3;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/9/20
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            return sum(root, root.val);
        } else return 0;
    }

    private int sum(TreeNode node, int sum) {
        if (node.left != null) {
            if (node.right != null) {
                return sum(node.left, sum * 10 + node.left.val) + sum(node.right, sum * 10 + node.right.val);
            } else {
                return sum(node.left, sum * 10 + node.left.val);
            }
        } else {
            if (node.right != null) {
                return sum(node.right, sum * 10 + node.right.val);
            } else return sum;
        }
    }

}
