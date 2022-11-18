package shigz.learn.y22.m10.w2;

import shigz.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/10/8
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        deal(root, resultList, valueList);
        return resultList;
    }

    private void deal(TreeNode node, List<String> resultList, List<Integer> valueList) {
        valueList.add(node.val);
        if (node.left != null) {
            deal(node.left, resultList, valueList);
            if (node.right != null) {
                deal(node.right, resultList, valueList);
            }
        } else {
            if (node.right != null) {
                deal(node.right, resultList, valueList);
            } else {
                if (1 < valueList.size()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(valueList.get(0));
                    for (int i = 1; i < valueList.size(); i++) {
                        sb.append("->").append(valueList.get(i));
                    }
                    resultList.add(sb.toString());
                } else {
                    resultList.add(valueList.get(0).toString());
                }
            }
        }
        valueList.remove(valueList.size() - 1);
    }

}
