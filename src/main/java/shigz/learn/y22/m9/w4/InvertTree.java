package shigz.learn.y22.m9.w4;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/9/29
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode node = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = node;
        }
        return root;
    }

}
