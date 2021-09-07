package com.java.easy;

import com.java.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历：
 *  先(根)序遍历：根左右
 *  中(根)序遍历：左根右
 *  后(根)序遍历：左右根
 *
 */
public class e94_二叉树的中序遍历 {

    /**输入一颗二叉树，返回二叉树的中序遍历结果
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 解释：              1
     *         null                2
     *                        3         null
     *
     * 如上：先序遍历root=[1,null,2,3]，输入中序遍历：root=[1,3,2]
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3,null,null);
        TreeNode root2 = new TreeNode(2,root3,null);
        TreeNode root1 = new TreeNode(1,null,root2);
        System.out.println(inorderTraversal(root1).toString());
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (null == root) {
            return ret;
        }

        getOrder(root, ret);
        return ret;
    }

    public static void getOrder(TreeNode root, List<Integer> ret) {
        if (null == root) {
            return;
        }

        // 先获取左孩子
        getOrder(root.left, ret);
        ret.add(root.val);

        // 再获取右孩子
        getOrder(root.right, ret);
    }

}
