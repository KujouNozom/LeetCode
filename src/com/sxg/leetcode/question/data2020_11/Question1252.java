package com.sxg.leetcode.question.data2020_11;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_11.Question1252
 * @Author: Su_N
 * @Date: 2020/11/4 22:10
 * @Description: 统计每个行和每个列出现的次数，然后遍历矩阵每个位置[i,j]，i的次数+j的次数是奇数的话，这个位置就是奇数
 *
 * 1252. 奇数值单元格的数目
 *
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 *
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * 示例 2：
 *
 * 输入：n = 2, m = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 *
 *
 *
 * 提示：
 *
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 */
public class Question1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[] rowCounts = new int[n];
        int[] colCounts = new int[m];

        for (int[] indice : indices) {
            rowCounts[indice[0]]++;
            colCounts[indice[1]]++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((rowCounts[i] + colCounts[j]) % 2 == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
