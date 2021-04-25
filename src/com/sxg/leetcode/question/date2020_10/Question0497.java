package com.sxg.leetcode.question.date2020_10;

import java.util.Random;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0497
 * @Author: Su_N
 * @Date: 2020/10/20 23:04
 * @Description: 计算所有矩形中的点的数量sum，并且计算每个矩阵的上界是哪个数组，然后随机一个0-sum的值，通过上界计算在哪个矩形中，通过偏移计算横纵坐标
 * 497. 非重叠矩形中的随机点
 *
 * 给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。
 *
 * 提示：
 *
 * 整数点是具有整数坐标的点。
 * 矩形周边上的点包含在矩形覆盖的空间中。
 * 第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。
 * 每个矩形的长度和宽度不超过 2000。
 * 1 <= rects.length <= 100
 * pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。
 * pick 最多被调用10000次。
 *
 *
 *
 * 示例 1：
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * 输出:
 * [null,[4,1],[4,1],[3,3]]
 *
 * 示例 2：
 *
 * 输入:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * 输出:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 *
 *
 *
 * 输入语法的说明：
 *
 * 输入是两个列表：调用的子例程及其参数。Solution 的构造函数有一个参数，即矩形数组 rects。pick 没有参数。参数总是用列表包装的，即使没有也是如此。
 */
public class Question0497 {
    static class Solution {
        private int[] sumList;

        private int sum;

        private Random random;

        private int[][] rects;

        public Solution(int[][] rects) {
            this.random = new Random();
            this.sum = 0;
            this.sumList = new int[rects.length];
            this.rects = rects;
            for (int index = 0; index < rects.length; index++) {
                int rect[] = rects[index];
                sum = sum + ((rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1));
                sumList[index] = sum;
            }
        }

        public int[] pick() {
            int num = random.nextInt(sum);
            int index = 0;
            while (sumList[index] <= num) {
                index++;
            }

            int deviation = num - (index > 0 ? sumList[index - 1] : 0);
            int rect[] = rects[index];
            int length = rect[2] - rect[0] + 1;
            int x = rects[index][0] + deviation % length;
            int y = rects[index][1] + deviation / length;

            return new int[]{x, y};
        }
    }
}
