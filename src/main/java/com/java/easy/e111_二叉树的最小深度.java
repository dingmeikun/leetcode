package com.java.easy;

import com.java.comm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树
 * 深度优先搜索
 * 广度优先搜索
 * 二叉树
 */
public class e111_二叉树的最小深度 {

    /**
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 返回它的最小深度 1
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode l15 = new TreeNode(15, null, null);
        TreeNode r7 = new TreeNode(7, null, null);
        TreeNode l9 = new TreeNode(9, null, null);
        TreeNode r20 = new TreeNode(20, l15, r7);
        TreeNode root = new TreeNode(3, l9, r20);
        System.out.println(minDepth1(root));
    }

    /**
     * 深度优先算法
     *
     *      首先可以想到使用深度优先搜索的方法，遍历整棵树，记录最小深度。
     *      对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题。
     *
     *  理解：遍历二叉树，针对每一个非叶子节点，都计算其左右子节点的深度，递归调用！需要做好边界值判定：左右子节点为空了，或者当前节点为空了
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }

        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

    /**
     * 广度优先算法
     *
     *      同样，我们可以想到使用广度优先搜索的方法，遍历整棵树。
     *      当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小
     *
     * 理解：构造一个队列，做层序遍历：每一次遍历都是对二叉树的一层做遍历，
     *      当遍历某一层树节点时判断：左右子节点都为空，则表明此节点为最小深度节点，可直接返回。
     *
     * @param root
     * @return
     */
    public static int minDepth1(TreeNode root) {
        int depth = 0;
        if (null == root) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) { // 左右子节点为空，说明当前node是最小深度节点
                    return depth;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
