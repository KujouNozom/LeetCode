package com.sxg.leetcode.question.data2020_11;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName: Question0349
 * @Author: Su_N
 * @Date: 2020/11/3 0:18
 * @Description: hash
 * 349. 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Question0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = getSet(nums1);
        Set<Integer> set2 = getSet(nums2);
        Set<Integer> comp1 = set1.size() > set2.size() ? set2 : set1;
        Set<Integer> comp2 = set1.size() > set2.size() ? set1 : set2;
        Set<Integer> tempAns = new LinkedHashSet<>();

        for (int temp : comp1) {
            if (comp2.contains(temp)) {
                tempAns.add(temp);
            }
        }

        int[] ans = new int[tempAns.size()];
        Iterator<Integer> iterator = tempAns.iterator();
        for (int index = 0; index < ans.length; index++) {
            ans[index] = iterator.next();
        }

        return ans;
    }

    private Set<Integer> getSet(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int temp : nums) {
            set.add(temp);
        }
        return set;
    }
}
