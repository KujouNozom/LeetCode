package com.sxg.leetcode.question.data2021_04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Question1072
 * @Author: Su_N
 * @Date: 2021/3/1 22:39
 * @Description: 1072. 按列翻转得到最大值等行数
 */
public class Question1072 {
    public static void main(String[] args) {
        Question1072 demo = new Question1072();
        demo.maxEqualRowsAfterFlips(new int[][] {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}});
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int length = matrix.length;
        Map<String, Integer> counts = new HashMap<>();

        for (int index = 0; index < length; index++) {
            int[] values = matrix[index];
            String value = getValueString(matrix, index, values);
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        return Collections.max(counts.values());
    }

    private String getValueString(int[][] matrix, int index, int[] values) {
        StringBuilder value = new StringBuilder();
        int valueLength = values.length;
        if (matrix[index][0] == 0) {
            for (int valueIndex = 0; valueIndex < valueLength; valueIndex++) {
                value.append(values[valueIndex] ^ 1);
            }
        } else {
            for (int valueIndex = 0; valueIndex < valueLength; valueIndex++) {
                value.append(values[valueIndex]);
            }
        }
        return value.toString();
    }
}
