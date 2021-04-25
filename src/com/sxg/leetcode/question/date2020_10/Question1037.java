package com.sxg.leetcode.question.date2020_10;

/**
 * @ClassName: Question1037
 * @Author: Su_N
 * @Date: 2020/10/29 22:15
 * @Description: 斜率
 * 计算斜率获取三个点在不在一条直线
 * 1037. 有效的回旋镖
 *
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 *
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,1],[2,3],[3,2]]
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：[[1,1],[2,2],[3,3]]
 * 输出：false
 *
 *
 *
 * 提示：
 *
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 */
public class Question1037 {
    public boolean isBoomerang(int[][] points) {
        return (points[2][1] - points[0][1]) * (points[1][0] - points[0][0])
                != (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]);
    }
}
