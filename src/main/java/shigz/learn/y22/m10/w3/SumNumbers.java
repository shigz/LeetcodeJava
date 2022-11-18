package shigz.learn.y22.m10.w3;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/10/17
 */
public class SumNumbers {

    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers(TreeNode root) {
        // write code here
        return root != null ? sumNumbers(root, root.val) : 0;
    }

    private int sumNumbers(TreeNode root, int pre) {
        if (root.left != null) {
            if (root.right != null) {
                return sumNumbers(root.right, pre * 10 + root.right.val) + sumNumbers(root.left, pre * 10 + root.left.val);
            } else {
                return sumNumbers(root.left, pre * 10 + root.left.val);
            }
        } else {
            if (root.right != null) {
                return sumNumbers(root.right, pre * 10 + root.right.val);
            } else {
                return pre;
            }
        }
    }

}
