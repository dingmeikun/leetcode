package com.java.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e118_杨辉三角 {

    /**
     * 输入一个行数numRows，构造一个杨辉三角、打印出所有行的结果
     *   杨辉三角：每个值：右上角+左上角
     *       1            1              1
     *       2           1 1             1 1
     *       3          1 2 1            1 2 1
     *       4         1 3 3 1           1 3 3 1
     *       5        1 4 6 4 1          1 4 6 4 1
     *       6       1 5 10 10 5 1  =>   1 5 10 10 5 1
     *
     *   输入：5
     *   输出：[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate1(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> an = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                List<Integer> tmp = ans.get(i - 1);
                an.add(getVal(tmp, j)+getVal(tmp, j-1));

            }
            ans.add(an);
        }
        return ans;
    }
    public static int getVal(List<Integer> tmp, int j) {
        int ret = 0;
        try {
            ret = tmp.get(j);
        } catch (Exception e) {
        }
        return ret;
    }

    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> an = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    an.add(1);
                }else {
                    an.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                }
            }
            ans.add(an);
        }
        return ans;
    }
}
