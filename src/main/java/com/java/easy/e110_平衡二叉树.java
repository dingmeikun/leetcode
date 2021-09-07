package com.java.easy;

import com.java.comm.TreeNode;

public class e110_平衡二叉树 {

    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(isBalanced(root));
    }

    /**
     * 判断是否为平衡二叉树
     *
     *          3
     *       9    20
     *           15 7
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
