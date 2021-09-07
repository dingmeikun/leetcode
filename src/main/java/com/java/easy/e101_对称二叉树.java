package com.java.easy;

import com.java.comm.TreeNode;

public class e101_对称二叉树 {

    public static void main(String[] args) {
        TreeNode child1 = new TreeNode(4);
        TreeNode child2 = new TreeNode(3);
        TreeNode left = new TreeNode(2, child2, child1);
        TreeNode right = new TreeNode(2, child1, child2);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }

        return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
    }
}
