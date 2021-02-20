package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import java.util.List;

/**
 * @ClassName: Question0120
 * @Author: Su_N
 * @Date: 2020/5/27 9:30
 * @Description: 动态规划，两种方式，从上到下和从下到上
 * 这里我们使用从下到上，这样可以直接获得答案，因为顶部只有一个元素
 * 从上到下的话，需要判断最低层那个是最小的元素
 * f(i,j) 表示 到达第i行j列的最小路径和，初始状态是最下面一行f(i,j) = triangle(i,j)
 * f(i,j) = min(f(i+1,j),f(i+1,j+1)) + triangle(i,j)
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * <p>
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Question0120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        for (int i = triangle.size() - 1 - 1; i >= 0; i--) {
            List<Integer> levelTemp = triangle.get(i);
            List<Integer> levelDownTemp = triangle.get(i + 1);
            for (int j = 0; j < levelTemp.size(); j++) {
                levelTemp.set(j, Math.min(levelDownTemp.get(j), levelDownTemp.get(j + 1)) + levelTemp.get(j));
            }
        }

        return triangle.get(0).get(0);

    }
}
