package com.java.sort;

/**
 * 选择排序：有一个数组arr[n]
 * 取arr[0]作为有序队列[0]，取arr[1]在队列Q中从后往前比较[0]，如果大于某一个值，则放在它后面
 * 取[0-1]作为有序队列[0-1]，取arr[2]在队列Q中从后往前比较[1-0]，如果大于某一个值，则放在它后面
 * 取[0-1-2]作为有序队列[0-1-2]，取arr[3]在队列Q中从后往前比较[2-1-0]，如果大于某一个值，则放在它后面
 */
public class 插入排序 {

    public static void main(String[] args) {
        int arr[] = new int[]{3,5,4,6,8,2,1,0,9};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void insertSort(int arr[]) {
        int n = arr.length;
        int cur = 0, pre;
        for (int i = 1; i < n; i++) {
            pre = i;
            for (int j = cur; j >= 0; j--) {
                if (arr[pre] < arr[j]) {
                    int t = arr[pre];
                    arr[pre] = arr[j];
                    arr[j] = t;
                }
                pre --;
            }
            cur ++;
        }
    }
}
