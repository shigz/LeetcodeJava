package shigz.learn.y22.m9.w3;

import shigz.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/21
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        deal(root,resultList);
        return resultList;
    }

    private void deal(TreeNode node,List<Integer> resultList) {
        if (node != null) {
            resultList.add(node.val);
            deal(node.left,resultList);
            deal(node.right,resultList);
        }
    }

}
