package com.sxg.leetcode.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Question0693
 * @Author: Su_N
 * @Date: 2021/2/20 21:26
 * @Description: 697. 数组的度
 */
public class Question0693 {
    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        int max = -1;
        Map<Integer, List<Integer>> indexesMap = new HashMap<>(length);

        for (int index = 0; index < length; index++) {
            int value = nums[index];
            List<Integer> indexes = indexesMap.getOrDefault(value, new ArrayList<>());
            indexes.add(index);
            indexesMap.put(value, indexes);
            max = Math.max(max, indexes.size());
        }


        int ans = Integer.MAX_VALUE;
        for (List<Integer> indexes : indexesMap.values()) {
            if (indexes.size() == max) {
                ans = Math.min(ans, indexes.get(indexes.size() - 1) - indexes.get(0) + 1);
            }
        }

        return ans;
    }
}
