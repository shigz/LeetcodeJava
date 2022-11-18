package shigz.learn.y22.m10.w2;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/10/13
 */
public class Rob3 {

    public int rob(TreeNode root) {
        int[] resultArr = robBy(root);
        return Math.max(resultArr[0], resultArr[1]);
    }

    private int[] robBy(TreeNode node) {
        int[] resultArr = new int[2];
        if (node != null) {
            int[] leftRobArr = robBy(node.left);
            int[] rightRobArr = robBy(node.right);
            resultArr[0] = node.val + leftRobArr[1] + rightRobArr[1];
            resultArr[1] = Math.max(leftRobArr[0], leftRobArr[1]) + Math.max(rightRobArr[0], rightRobArr[1]);
        }
        return resultArr;
    }

}
