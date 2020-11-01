package com.sxg.leetcode.question.date2020_10;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName: Question1122
 * @Author: Su_N
 * @Date: 2020/10/29 22:09
 * @Description: 计数排序
 * 统计每个数字出现的次数，使用带排序的 treemap,按照 arr2 的顺序输出，然后按顺序输出剩下的元素
 * 1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class Question1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> numCounts = new TreeMap<>();
        for (int temp : arr1) {
            numCounts.put(temp, numCounts.getOrDefault(temp, 0) + 1);
        }

        int[] ans = new int[arr1.length];
        int index = 0;
        for (int temp : arr2) {
            int count = numCounts.get(temp);
            while (count != 0) {
                ans[index++] = temp;
                count--;
            }
            numCounts.remove(temp);
        }

        for (int temp : numCounts.keySet()) {
            int count = numCounts.get(temp);
            while (count != 0) {
                ans[index++] = temp;
                count--;
            }
        }

        return ans;
    }

}
