package com.java.easy;

public class e35_搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int[] nums1 = new int[]{1,3,5,6};
        int[] nums2 = new int[]{1,3,5,6,8};
        int[] nums3 = new int[]{1,3,5,6};
        int[] nums4 = new int[]{1};
        int[] nums5 = new int[]{1,3};
        int[] nums6 = new int[]{3,5,7,9,10};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums1, 2));
        System.out.println(searchInsert(nums2, 7));
        System.out.println(searchInsert(nums3, 0));
        System.out.println(searchInsert(nums4, 0));
        System.out.println(searchInsert(nums5, 0));
        System.out.println(searchInsert(nums6, 8));
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length -1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (target < nums[mid]) {
                j = mid - 1;
            }
            else if (target > nums[mid]) {
                i = mid + 1;
            }
        }
        return i;
    }

    public static int searchInsert1(int[] nums, int target) {
        int i = 0, j = nums.length -1, ans = -1;
        while (i < j) {
            int mid = i + (j - i)/2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }
            else if (target < nums[mid]) {
                j = mid - 1;
            }
            else if (target > nums[mid]) {
                i = mid + 1;
            }
        }
        if (i == j) {
            ans = i;
            if (target > nums[i]) {
                ans += 1;
            }
        }
        if (i > j) {
            ans = i;
        }

        return ans;
    }
}
