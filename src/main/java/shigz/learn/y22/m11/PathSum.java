package shigz.learn.y22.m11;

import shigz.common.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 大史 on 2022/11/18
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 */
public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
//        return pathSum(root, targetSum, new ArrayList<>());
        Map<Long, Integer> targetCountMap = new HashMap<>();
        targetCountMap.put(0L, 1);
        return pathSum(root, 0, targetSum, targetCountMap);
    }

    private int pathSum(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> targetCountMap) {
        if (node == null) return 0;
        currentSum += node.val;
        //获取与当前前缀和之差为目标值的和的个数
        int result = targetCountMap.getOrDefault(currentSum - targetSum, 0);
        targetCountMap.put(currentSum, 1 + targetCountMap.getOrDefault(currentSum, 0));
        //获取与左节点前缀和之差为目标值的和的个数
        result += pathSum(node.left, currentSum, targetSum, targetCountMap);
        //获取与右节点前缀和之差为目标值的和的个数
        result += pathSum(node.right, currentSum, targetSum, targetCountMap);
        //清除添加的前缀和,避免污染其它节点的计算
        targetCountMap.put(currentSum, targetCountMap.getOrDefault(currentSum, 0) - 1);
        return result;
    }

    //暴力搜索
    //通过
    //时间和内存排行较靠后
    private int pathSum(TreeNode node, int targetSum, List<Long> sumList) {
        if (node == null) return 0;
        int result = 0;
        for (int index = 0; index < sumList.size(); index++) {
            long sum = sumList.get(index) + node.val;
            if (sum == targetSum) result += 1;
            sumList.set(index, sum);
        }
        if (node.val == targetSum) result += 1;
        sumList.add((long) node.val);
        result += pathSum(node.left, targetSum, sumList);
        result += pathSum(node.right, targetSum, sumList);
        sumList.remove(sumList.size() - 1);
        for (int index = 0; index < sumList.size(); index++) {
            sumList.set(index, sumList.get(index) - node.val);
        }
        return result;
    }

}
