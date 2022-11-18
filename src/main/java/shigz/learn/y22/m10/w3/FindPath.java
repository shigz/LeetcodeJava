package shigz.learn.y22.m10.w3;

import shigz.common.TreeNode;

import java.util.ArrayList;

/**
 * Created by 大史 on 2022/10/17
 */
public class FindPath {

    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        ArrayList<Integer> valueList = new ArrayList<>();
        deal(valueList, root, expectNumber);
        return resultList;
    }

    private void deal(ArrayList<Integer> valueList, TreeNode node, int remainNumber) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                if (node.val == remainNumber) {
                    ArrayList<Integer> integers = new ArrayList<>(valueList);
                    integers.add(node.val);
                    resultList.add(integers);
                }
            } else {
                valueList.add(node.val);
                deal(valueList, node.left, remainNumber - node.val);
                deal(valueList, node.right, remainNumber - node.val);
                valueList.remove(valueList.size() - 1);
            }
        }
    }

}
