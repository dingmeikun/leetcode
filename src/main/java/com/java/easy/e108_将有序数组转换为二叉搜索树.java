package com.java.easy;

import com.java.comm.TreeNode;

public class e108_将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length - 1);
    }

    /**
     * 关键在于判断if ( left > right)
     *
     *      1.当left == right时，此时说明当前的元素需要作为叶子节点，其左右子树都应该为空
     *      2.恰好left取(nums, left, mid-1); 此时left=right=mid,所以left实际取(nums, left, left-1);所以left > left-1 直接返回null
     *      2.恰好right取(nums, mid+1, right)；此时left=right=mid,所以right实际取(nums, right+1, right);所以right+1 > right 直接返回null
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static TreeNode getBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getBST(nums, left, mid-1);
        root.right = getBST(nums, mid+1, right);
        return root;
    }
}
