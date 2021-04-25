package com.sxg.leetcode.question.data2020_0x.no0301_0350;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Question0350
 * @Author: Su_N
 * @Date: 2020/10/22 22:23
 * @Description: 统计两个数字出现数字的次数，然后去最小值
 * 350. 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Question0350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts1 = getCounts(nums1);
        Map<Integer, Integer> counts2 = getCounts(nums2);

        List<Integer> result = new LinkedList<>();

        for (int num : counts1.keySet()) {
            int minCount = Math.min(counts1.getOrDefault(num, 0), counts2.getOrDefault(num, 0));
            for (int temp = 0; temp < minCount; temp++) {
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            ans[index] = result.get(index);
        }

        return ans;
    }

    private Map<Integer, Integer> getCounts(int[] nums) {
        Map<Integer, Integer> counts = new HashMap(nums.length);
        for (int temp : nums) {
            counts.put(temp, counts.getOrDefault(temp, 0) + 1);
        }
        return counts;
    }
}
