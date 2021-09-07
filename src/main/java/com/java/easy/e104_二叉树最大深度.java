package com.java.easy;

import com.java.comm.TreeNode;

public class e104_二叉树最大深度 {

    /**
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 返回它的最大深度 3
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
