package com.java.offer;

import com.java.comm.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指Offer_34_二叉树中和为某一值的路径 {

    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 示例:
     * 给定二叉树 [3,9,20,null,null,15,7]，target=30
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回:
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(pathSum(root, 30).toString());
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<List<Integer>> paths = new LinkedList<>();
        queue.offer(root);
        paths.offer(new ArrayList<Integer>(){{add(root.val);}});
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                List<Integer> list = paths.poll();
                int sum = list.stream().mapToInt(Integer::intValue).sum();

                if (node.left == null && node.right == null && sum == target) {
                    ans.add(list);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    List<Integer> left = new ArrayList<>(list);
                    left.add(node.left.val);
                    paths.offer(left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    List<Integer> right = new ArrayList<>(list);
                    right.add(node.right.val);
                    paths.offer(right);
                }
            }
        }
        return ans;
    }
}
