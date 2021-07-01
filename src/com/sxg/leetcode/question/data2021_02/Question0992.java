package com.sxg.leetcode.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Question0992
 * @Author: Su_N
 * @Date: 2021/2/10 20:12
 * @Description: 992. K 个不同整数的子数组
 */
public class Question0992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> windowCounts = new HashMap<>(K + 1);
        int ans = 0;
        int left = 0;
        int right = 0;
        int length = A.length;
        while (right < length && left <= right) {
            while (right < length && windowCounts.size() < K) {
                addValue(windowCounts, A[right++]);
            }
            // 此时满足条件，但是我们要获取当前左端点匹配的所有右端点
            // 我们使用一个新的 right 指针，继续遍历，查找满足的有端点
            int rightNew = right;
            while (rightNew < length && windowCounts.size() == K) {
                addValue(windowCounts, A[rightNew++]);
            }
            ans += rightNew - right;
            if (windowCounts.size() == K && rightNew == length) {
                ans++;
            }

            // 删除 right到rightnew的元素，回溯
            for (int index = rightNew - 1; index >= right; index--) {
                removeValue(windowCounts, A[index]);
            }

            // 接下来移动左端点
            removeValue(windowCounts, A[left++]);
        }

        while (left < length && windowCounts.size() == K) {
            ans++;
            removeValue(windowCounts, A[left]);
            left++;
        }

        return ans;
    }

    private void removeValue(Map<Integer, Integer> windowCounts, int removeValue) {
        int count = windowCounts.get(removeValue);
        count--;
        if (count == 0) {
            windowCounts.remove(removeValue);
        } else {
            windowCounts.put(removeValue, count);
        }
    }

    private void addValue(Map<Integer, Integer> windowCounts, int addValue) {
        if (windowCounts.containsKey(addValue)) {
            windowCounts.put(addValue, windowCounts.get(addValue) + 1);
        } else {
            windowCounts.put(addValue, 1);
        }
    }
}
