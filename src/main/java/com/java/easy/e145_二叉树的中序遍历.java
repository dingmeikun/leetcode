package com.java.easy;

import com.java.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class e145_二叉树的中序遍历 {

    /**
     * 给定一颗二叉树，将二叉树按照前序遍历打印节点值。
     *
     *      给定:     3
     *             9   20
     *               15  7
     *
     *      给出：中序遍历：[9,3,15,20,7]
     *      解释：中序遍历(左根右)，先遍历左节点、再遍历根节点、后遍历右节点
     */
    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(inorderTraversal(root));
    }

    /**
     * 递归的方式：先左、再根、后右
     *
     * @param root
     * @return
     */
    public static int[] inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (null == root) {
            return new int[]{};
        }

        getTraversal(root.left, ans);
        ans.add(root.val);
        getTraversal(root.right, ans);

        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

    /**
     * List 返回
     *
     * @param root
     * @return
     */
    public static List<Integer> proorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }

        getTraversal(root.left, ans);
        ans.add(root.val);
        getTraversal(root.right, ans);
        return ans;
    }

    public static void getTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        getTraversal(root.left, ans);
        ans.add(root.val);
        getTraversal(root.right, ans);
    }
}
