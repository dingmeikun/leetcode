package com.java.easy;

import com.java.comm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class e257_二叉树的所有路径 {

    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     *
     * 示例：输入：root = [1,2,3,null,5]
     *      输出：["1->2->5","1->3"]
     *
     *      输入：root = [1]
     *      输出：["1"]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r6 = new TreeNode(6, null, null);
        TreeNode l3 = new TreeNode(3, null, null);
        TreeNode r1 = new TreeNode(1, null, null);
        TreeNode l7 = new TreeNode(7, l9, r6);
        TreeNode r2 = new TreeNode(2, l3, r1);
        TreeNode root = new TreeNode(4, l7, r2);
        System.out.println(binaryTreePaths(root));
    }

    /**
     * 这题与之前很多二叉树的题目很相似，采用层序遍历可以很好地解决
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> path = new LinkedList<>();
        queue.offer(root);
        path.offer(Integer.toString(root.val));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String paths = path.poll();

            if (node.left == null && node.right == null) {
                ans.add(paths);
            }
            if (node.left != null) {
                queue.offer(node.left);
                path.offer(new StringBuffer(paths).append("->").append(node.left.val).toString());
            }
            if (node.right != null) {
                queue.offer(node.right);
                path.offer(new StringBuffer(paths).append("->").append(node.right.val).toString());
            }
        }
        return ans;
    }
}
