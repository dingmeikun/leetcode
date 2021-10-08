package com.java.easy;

public class e278_第一个错误的版本 {

    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    /**
     * 判断第一个错误版本，可以使用二分法，一直判断第一个出错的版本即可
     *
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (right - left)/2 + left; // 避免right+left溢出
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**父类提供的方法，这里只做返回，不做校验
     *
     * @param mid
     * @return
     */
    private static boolean isBadVersion(int mid) {
        return true;
    }
}
