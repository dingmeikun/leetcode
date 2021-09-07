package com.java.medium;

public class m11_盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height1 = new int[]{1,2,1};
        int[] height2 = new int[]{4,3,2,1,4};
        int[] height3 = new int[]{1,1};
        int maxArea = maxArea2(height);
        int maxArea1 = maxArea2(height1);
        int maxArea2 = maxArea2(height2);
        int maxArea3 = maxArea2(height3);
        System.out.println(maxArea);
        System.out.println(maxArea1);
        System.out.println(maxArea2);
        System.out.println(maxArea3);
    }

    /**
     * 相对的最优解：使用的双指针，以及指针向内移动解法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = height[left] < height[right] ?
                    Math.max(maxArea, (right - left) * height[left++]) :
                    Math.max(maxArea, (right - left) * height[right--]);
        }
        return maxArea;
    }

    /**
     * 最初的版本 - 暴力解法
     *
     * 但是，当数据量很大的时候，可能超时，被解法提交结果：无结果
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            if (height[i] == 0) continue;
            for (int j = i + 1; j < length; j++) {
                if (height[i] == 0) continue;
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 针对版本一的暴力解法，做出的优化
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}
