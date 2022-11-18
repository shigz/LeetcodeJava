package shigz.learn.y22.m10.w3;

import shigz.common.TreeNode;

/**
 * Created by 大史 on 2022/10/18
 */
public class SortedArrayToBST {

    /**
     *
     * @param num int整型一维数组
     * @return TreeNode类
     */
    public TreeNode sortedArrayToBST (int[] num) {
        // write code here
        return sortedArrayToBST(num,0,num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num,int start,int end) {
        if (start == end) {
            return new TreeNode(num[start]);
        } else if (start + 1 == end) {
            TreeNode node = new TreeNode(num[start]);
            node.right = new TreeNode(num[end]);
            return node;
        } else if (start + 2 == end) {
            TreeNode node = new TreeNode(num[start + 1]);
            node.left = new TreeNode(num[start]);
            node.right = new TreeNode(num[end]);
            return node;
        } else {
            int mid = start + (end - start) / 2;
            TreeNode node = new TreeNode(num[mid]);
            node.left = sortedArrayToBST(num, start, mid - 1);
            node.right = sortedArrayToBST(num, mid + 1, end);
            return node;
        }
    }

}
