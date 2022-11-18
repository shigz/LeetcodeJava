package shigz.learn.y22.m9.w4;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/9/30
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return arrAncestor(root,p,q)[0];
    }

    private TreeNode[] arrAncestor(TreeNode node, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[]{null, null, null};
        if (node != null) {
            TreeNode[] leftAncestorArr = arrAncestor(node.left, p, q);
            if (leftAncestorArr[0] != null) return leftAncestorArr;
            TreeNode[] rightAncestorArr = arrAncestor(node.right, p, q);
            if (rightAncestorArr[0] != null) return rightAncestorArr;
            TreeNode pIndex = leftAncestorArr[1] != null ? leftAncestorArr[1] : (rightAncestorArr[1] != null ? rightAncestorArr[1] : null);
            TreeNode qIndex = leftAncestorArr[2] != null ? leftAncestorArr[2] : (rightAncestorArr[2] != null ? rightAncestorArr[2] : null);

            if (pIndex != null) {
                result[1] = pIndex;
                if (qIndex != null) {
                    result[2] = qIndex;
                    result[0] = node;
                } else {
                    if (node.equals(q)) {
                        result[0] = node;
                    }
                }
            } else {
                if (qIndex != null) {
                    result[2] = qIndex;
                    if (node.equals(p)) {
                        result[0] = node;
                    }
                } else {
                    if (node.equals(p)) {
                        result[1] = node;
                    } else if (node.equals(q)) {
                        result[2] = node;
                    }
                }
            }
        }
        return result;
    }

}
