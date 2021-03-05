package com.sxg.leetcode.question;

import java.util.*;

/**
 * @ClassName: Questiono9696
 * @Author: Su_N
 * @Date: 2021/3/3 0:12
 * @Description: 969. 煎饼排序 排序
 */
public class Question0969 {
    public List<Integer> pancakeSort(int[] arr) {
        Map<Integer, Integer> indexMap = new TreeMap<>(Collections.reverseOrder());
        int length = arr.length;
        for (int index = 0; index < length; index++) {
            indexMap.put(arr[index], index);
        }

        List<Integer> values = new ArrayList<>(indexMap.size());
        values.addAll(indexMap.keySet());

        List<Integer> ans = new ArrayList<>();
        int currentLength = length;
        for (int value : values) {
            int index = indexMap.get(value);
            for (int reverseIndex : ans) {
                if (index < reverseIndex) {
                    index = (reverseIndex - 1) - index;
                }
            }
            ans.add(index + 1);
            ans.add(currentLength--);
        }

        return ans;
    }
}
