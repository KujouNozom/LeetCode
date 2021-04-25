package com.sxg.leetcode.question.data2020_0x.no0351_0400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Question0373
 * @Author: Su_N
 * @Date: 2020/7/27 22:27
 * @Description: 索引数组
 * 使用一个数组作为基础数组，声明另一个索引数组，记录基础数组对应位置的元素和另一个数组元素结合的索引位置
 * 索引数组初始化为0
 * 每次计算基础数组中每个元素和另一个数组对应索引位置的和，去最小的一个加入结果结合，并把索引数组相应位置的值+1
 *
 *
 * 373. 查找和最小的K对数字
 *
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 */
public class Question0373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new ArrayList<>();
        }

        int length1 = nums1.length;
        int length2 = nums2.length;

        int[] baseIndexs = new int[length1];
        List<List<Integer>> answers = new ArrayList<>();
        int count = Math.min(k, length1 * length2);

        while (answers.size() < count) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int index = 0; index < baseIndexs.length; index++) {
                if (baseIndexs[index] < length2) {
                    int tempValue = nums1[index] + nums2[baseIndexs[index]];
                    if (minValue >= tempValue) {
                        minValue = tempValue;
                        minIndex = index;
                    }
                }
            }
            answers.add(Arrays.asList(nums1[minIndex], nums2[baseIndexs[minIndex]]));
            baseIndexs[minIndex] += 1;
        }

        return answers;
    }
}
