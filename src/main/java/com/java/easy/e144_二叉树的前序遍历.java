package com.java.easy;

import com.java.comm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一颗二叉树，将二叉树按照前序遍历打印节点值。
 *
 *      给定:     3
 *             9   20
 *               15  7
 *
 *      给出：前序遍历：[3,9,20,15,7]
 *      解释：前序遍历(根左右)，先遍历根节点、再遍历左节点、后遍历右节点
 */
public class e144_二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(preorderTraversal(root));
    }

    /**
     * 递归的方式：先根、再左、后右
     *  [1,null,2,3] => [1,2,3]
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
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

        ans.add(root.val);
        getTraversal(root.left, ans);
        getTraversal(root.right, ans);
    }

    /**
     * 深度优先搜索 - 层序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

}
