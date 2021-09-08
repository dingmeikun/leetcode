package com.java.easy;

import com.java.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class e145_二叉树的后序遍历 {

    /**
     * 给定一颗二叉树，将二叉树按照前序遍历打印节点值。
     *
     *      给定:     3
     *             9   20
     *               15  7
     *
     *      给出：后序遍历：[9,15,7,20,3]
     *      解释：后序遍历(左右根)，先遍历左节点、再遍历右节点、后遍历根节点
     */
    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        getTraversal(root, ans);
        return ans;
    }

    public static void getTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        getTraversal(root.left, ans);
        getTraversal(root.right, ans);
        ans.add(root.val);
    }
}
