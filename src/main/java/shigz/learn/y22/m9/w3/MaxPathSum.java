package shigz.learn.y22.m9.w3;

import shigz.common.BaseObject;
import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/9/19
 */
public class MaxPathSum extends BaseObject {

    public int firstTry(TreeNode root) {
        return arrMaxSum(root)[1];
    }

    private int[] arrMaxSum(TreeNode node) {
        int[] leftMaxSumArr = node.left == null ? new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE} : arrMaxSum(node.left);
        int[] rightMaxSumArr = node.right == null ? new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE} : arrMaxSum(node.right);
        if (leftMaxSumArr[0] > 0) {
            if (rightMaxSumArr[0] > 0) {
                return new int[]{node.val + Math.max(leftMaxSumArr[0], rightMaxSumArr[0]), Math.max(leftMaxSumArr[1], Math.max(rightMaxSumArr[1], node.val + leftMaxSumArr[0] + rightMaxSumArr[0]))};
            } else {
                return new int[]{node.val + leftMaxSumArr[0], Math.max(leftMaxSumArr[1], Math.max(rightMaxSumArr[1], node.val + leftMaxSumArr[0]))};
            }
        } else {
            if (rightMaxSumArr[0] > 0) {
                return new int[]{node.val + rightMaxSumArr[0], Math.max(leftMaxSumArr[1], Math.max(rightMaxSumArr[1], node.val + rightMaxSumArr[0]))};
            } else {
                return new int[]{node.val, Math.max(leftMaxSumArr[1], Math.max(rightMaxSumArr[1], node.val))};
            }
        }
    }

}
