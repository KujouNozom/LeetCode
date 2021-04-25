package com.sxg.leetcode.question;

/**
 * @ClassName: Question0766
 * @Author: Su_N
 * @Date: 2020/12/8 23:53
 * @Description: 766. 托普利茨矩阵
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 示例 1:
 * 输入:
 * matrix = [
 * [1,2,3,4],
 * [5,1,2,3],
 * [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 *
 * 示例 2:
 * 输入:
 * matrix = [
 * [1,2],
 * [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 *
 * 说明:
 * matrix 是一个包含整数的二维数组。
 * matrix 的行数和列数均在 [1, 20]范围内。
 * matrix[i][j] 包含的整数在 [0, 99]范围内。
 * 进阶:
 * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
 * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
 */
public class Question0766 {
    private int m;

    private int n;

    private int[][] datas;

    public boolean isToeplitzMatrix(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.datas = matrix;
        for (int x = m - 1; x >= 0; x--) {
            if (!check(x, 0)) {
                return false;
            }
        }

        for (int y = 1; y < n; y++) {
            if (!check(0, y)) {
                return false;
            }
        }

        return true;
    }

    private boolean check(int x, int y) {
        int value = datas[x++][y++];
        while (x < m && y < n) {
            if (datas[x++][y++] != value) {
                return false;
            }
        }
        return true;
    }
}
