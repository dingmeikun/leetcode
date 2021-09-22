package com.java.easy;

import java.util.HashSet;
import java.util.Set;

public class e217_存在重复的元素II {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    /**
     * 使用滑动窗口，固定左右边界去判断是否存在符合条件的值 - 失败！ 问题：最大可以是K，也就是说可以小于K的[i,j]组合也符合条件！！
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0,r=l+k,n=nums.length-1;
        while(r <= n) {
            if (nums[l] == nums[r]) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

    /**
     * 使用哈希表：既然符合条件的数据是K，也就是说可以小于K，那么真正在判断的时候，不需要K的参与
     *
     *      这里使用一个Set结构，保持Set的容量最大为K，同时遍历数组：是否有新元素进来的时候，已经在set中存在：存在则满足条件，不存在则退出
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size()>k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
