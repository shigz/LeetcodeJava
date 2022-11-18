package shigz.learn.y22.m9.w3;

import shigz.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        deal(root,resultList);
        return resultList;
    }

    private void deal(TreeNode node,List<Integer> resultList) {
        if (node != null) {
            deal(node.left,resultList);
            deal(node.right,resultList);
            resultList.add(node.val);
        }
    }

}
