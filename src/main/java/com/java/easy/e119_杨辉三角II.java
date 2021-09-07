package com.java.easy;

import java.util.ArrayList;
import java.util.List;

public class e119_杨辉三角II {

    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(3));
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<>(1);
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> ret = new ArrayList<>(1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ret.add(1);
                }else{
                    ret.add(tmp.get(j) + tmp.get(j-1));
                }
            }
            tmp.clear();
            tmp.addAll(ret);
        }
        return tmp;
    }
}
