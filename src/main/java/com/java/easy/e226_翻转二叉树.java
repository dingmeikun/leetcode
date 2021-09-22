package com.java.easy;

import com.java.comm.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class e226_翻转二叉树 {

    /**
     * <p>输入：</p>
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * <p>输出：</p>
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 提示：深度优先遍历、广度优先便利、递归
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
        invertTree(root);
        invertTree1(root);
    }

    /**
     * 递归：我们看到，翻转二叉树就是将左右子节点交换，而且注意：是从上至下的层层左右子节点交换
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 递归的，交换子节点的左右子节点
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 层序遍历：使用广度优先遍历，一层一层的交换左右子节点
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 交换左右子节点
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }
}
