package com.java.easy;

import com.java.comm.TreeNode;

public class e100_相同的树 {

    /**
     * 判断是否为相同的树：需要明确边界值，以及他们的终止条件
     *  1.如果都为null，则为true
     *  2.如果有一个为null，则返回false
     *  3.如果他们的值不同，则返回false
     *
     *  4.递归p、q的左右孩子，循环1,2,3判断是否相等。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        System.out.println(isSameTree(new TreeNode(1), new TreeNode(1)));
        System.out.println(isSameTree(new TreeNode(), new TreeNode(1)));
        System.out.println(isSameTree(new TreeNode(1, left,right), new TreeNode(1,left,null)));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
