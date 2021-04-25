package com.sxg.leetcode.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Question0119
 * @Author: Su_N
 * @Date: 2021/2/12 9:54
 * @Description: 119. 杨辉三角 II
 */
public class Question0119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
