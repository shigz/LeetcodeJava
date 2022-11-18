package shigz.learn.y22.m10.w3;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/10/17
 */
public class HasPathSum {

    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root != null) {
            if (root.left == null && root.right == null) {
                return sum == root.val;
            } else {
                return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
            }
        }
        return false;
    }

}
