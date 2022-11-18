package shigz.learn.y22.m10.w3;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/10/17
 */
public class MaxPathSum {

    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxPathSum(TreeNode root) {
        // write code here
        if (root == null) return 0;
        int[] resultArr = maxPathSumOf(root);
        return Math.max(Math.max(resultArr[0], resultArr[1]), resultArr[2]);
    }

    private int[] maxPathSumOf(TreeNode node) {
        if (node.left != null) {
            int[] leftMaxArr = maxPathSumOf(node.left);
            if (node.right != null) {
                int[] rightMaxArr = maxPathSumOf(node.right);
                return new int[]{Math.max(node.val, Math.max(node.val + leftMaxArr[0], node.val + rightMaxArr[0])), Math.max(Math.max(Math.max(leftMaxArr[0], leftMaxArr[1]), leftMaxArr[2]), Math.max(Math.max(rightMaxArr[0], rightMaxArr[1]), rightMaxArr[2])), leftMaxArr[0] + node.val + rightMaxArr[0]};
            } else {
                if (leftMaxArr[0] <= 0) {
                    return new int[]{node.val, Math.max(Math.max(leftMaxArr[0], leftMaxArr[1]), leftMaxArr[2]), node.val};
                } else {
                    return new int[]{node.val + leftMaxArr[0], Math.max(Math.max(leftMaxArr[0], leftMaxArr[1]), leftMaxArr[2]), node.val + leftMaxArr[0]};
                }
            }
        } else {
            if (node.right != null) {
                int[] rightMaxArr = maxPathSumOf(node.right);
                if (rightMaxArr[0] <= 0) {
                    return new int[]{node.val, Math.max(Math.max(rightMaxArr[0], rightMaxArr[1]), rightMaxArr[2]), node.val};
                } else {
                    return new int[]{node.val + rightMaxArr[0], Math.max(Math.max(rightMaxArr[0], rightMaxArr[1]), rightMaxArr[2]), node.val + rightMaxArr[0]};
                }
            } else {
                return new int[]{node.val, node.val, node.val};
            }
        }
    }

}
