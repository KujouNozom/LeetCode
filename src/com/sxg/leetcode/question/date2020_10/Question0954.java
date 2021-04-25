package com.sxg.leetcode.question.date2020_10;

import java.util.*;

/**
 * @ClassName: Question0954
 * @Author: Su_N
 * @Date: 2020/10/31 19:44
 * @Description: Hash
 * 使用一个hash存储元素出现次数，然后key排序，每次取最小的一个n，map中删除n，同时n*2减去相应的数量
 * 954. 二倍数对数组
 *
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,1,3,6]
 * 输出：false
 *
 * 示例 2：
 *
 * 输入：[2,1,2,6]
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 *
 * 示例 4：
 *
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 *
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 */
public class Question0954 {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> nums = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        for (int temp : A) {
            nums.put(temp, nums.getOrDefault(temp, 0) + 1);
            keys.add(temp);
        }

        keys.sort(Comparator.comparingInt(Math::abs));
        int count = keys.size() / 2;
        Iterator<Integer> iterator = keys.iterator();

        while (iterator.hasNext() && count > 0) {
            Integer key = iterator.next();
            if (nums.getOrDefault(key, 0) > 0) {
                int numCount = nums.get(key);
                if (numCount > nums.getOrDefault(key * 2, -1)) {
                    return false;
                } else {
                    nums.remove(key);
                    nums.put(key * 2, nums.getOrDefault(key * 2, 0) - numCount);
                    count--;
                }
            }
        }

        return true;
    }
}
