package shigz.common;

import java.util.LinkedList;

/**
 * Created by 大史 on 2022/9/19
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    private TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(String[] nums) {
        if (0 < nums.length) {
            this.val = Integer.parseInt(nums[0]);
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            boolean isLeft = true;
            for (int index = 1; index < nums.length; index++) {
                TreeNode currentNode = queue.peek();
                if (isLeft) {
                    if (nums[index] != null) {
                        currentNode.left = new TreeNode(Integer.parseInt(nums[index]));
                        queue.offer(currentNode.left);
                    }
                    isLeft = false;
                } else {
                    if (nums[index] != null) {
                        currentNode.right = new TreeNode(Integer.parseInt(nums[index]));
                        queue.offer(currentNode.right);
                    }
                    queue.poll();
                    isLeft = true;
                }
            }
        }
    }

    public TreeNode(Integer[] nums) {
        if (0 < nums.length) {
            this.val = nums[0];
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            boolean isLeft = true;
            for (int index = 1; index < nums.length; index++) {
                TreeNode currentNode = queue.peek();
                if (isLeft) {
                    if (nums[index] != null) {
                        currentNode.left = new TreeNode(nums[index]);
                        queue.offer(currentNode.left);
                    }
                    isLeft = false;
                } else {
                    if (nums[index] != null) {
                        currentNode.right = new TreeNode(nums[index]);
                        queue.offer(currentNode.right);
                    }
                    queue.poll();
                    isLeft = true;
                }
            }
        }
    }

}
