package com.java.easy;

import com.java.comm.TreeNode;

import java.util.LinkedList;

public class e112_路径总和 {

    /**
     * 给你二叉树的根节点root和一个表示目标和的整数targetSum，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum
     *
     *          3
     *       9    20
     *          15  7
     * @param args
     */
    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(hasPathSum(root, 30));
    }

    /**
     * 使用层序遍历，记录二叉树顶层节点到每一层每个节点的路径和，并与targetSum比对
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left == null && node.right == null && node.val == targetSum) {
                    return true;
                }
                if (node.left != null) {
                    TreeNode left = node.left;
                    left.val = left.val + node.val;
                    queue.offer(left);
                }

                if (node.right != null) {
                    TreeNode right = node.right;
                    right.val = right.val + node.val;
                    queue.offer(right);
                }
            }
        }
        return false;
    }
}
