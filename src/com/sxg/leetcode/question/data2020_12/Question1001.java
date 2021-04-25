package com.sxg.leetcode.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Question1001
 * @Author: Su_N
 * @Date: 2020/12/10 22:58
 * @Description: 找规律，Hash
 * 找出行，列，对角的特点，使用Hash计算每一行/列/对角收到照射的灯的数量，当删除一个灯的时候，把对应的行/列/对角的数量减1
 * 1001. 网格照明
 * 困难
 * 在 N x N 的网格上，每个单元格 (x, y) 上都有一盏灯，其中 0 <= x < N 且 0 <= y < N 。
 * 最初，一定数量的灯是亮着的。lamps[i] 告诉我们亮着的第 i 盏灯的位置。每盏灯都照亮其所在 x 轴、y 轴和两条对角线上的每个正方形（类似于国际象棋中的皇后）。
 * 对于第 i 次查询 queries[i] = (x, y)，如果单元格 (x, y) 是被照亮的，则查询结果为 1，否则为 0 。
 * 在每个查询 (x, y) 之后 [按照查询的顺序]，我们关闭位于单元格 (x, y) 上或其相邻 8 个方向上（与单元格 (x, y) 共享一个角或边）的任何灯。
 * 返回答案数组 answer。每个值 answer[i] 应等于第 i 次查询 queries[i] 的结果。
 *
 * 示例：
 * 输入：N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * 输出：[1,0]
 * 解释：
 * 在执行第一次查询之前，我们位于 [0, 0] 和 [4, 4] 灯是亮着的。
 * 表示哪些单元格亮起的网格如下所示，其中 [0, 0] 位于左上角：
 * 1 1 1 1 1
 * 1 1 0 0 1
 * 1 0 1 0 1
 * 1 0 0 1 1
 * 1 1 1 1 1
 * 然后，由于单元格 [1, 1] 亮着，第一次查询返回 1。在此查询后，位于 [0，0] 处的灯将关闭，网格现在如下所示：
 * 1 0 0 0 1
 * 0 1 0 0 1
 * 0 0 1 0 1
 * 0 0 0 1 1
 * 1 1 1 1 1
 * 在执行第二次查询之前，我们只有 [4, 4] 处的灯亮着。现在，[1, 0] 处的查询返回 0，因为该单元格不再亮着。
 *
 * 提示：
 * 1 <= N <= 10^9
 * 0 <= lamps.length <= 20000
 * 0 <= queries.length <= 20000
 * lamps[i].length == queries[i].length == 2
 */
public class Question1001 {
    private Map<Integer, Integer> rowCount;

    private Map<Integer, Integer> colCount;

    private Map<Integer, Integer> diagonalLeftCount;

    private Map<Integer, Integer> diagonalRightCount;

    private Set<Integer> lampIndexes;

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        rowCount = new HashMap<>();
        colCount = new HashMap<>();
        diagonalLeftCount = new HashMap<>();
        diagonalRightCount = new HashMap<>();
        lampIndexes = new HashSet<>();
        int[] ans = new int[queries.length];

        initLamps(lamps, N);

        doQueries(N, queries, ans);

        return ans;
    }

    private void doQueries(int n, int[][] queries, int[] ans) {
        for (int index = 0; index < queries.length; index++) {
            int row = queries[index][0];
            int col = queries[index][1];
            if (check(row, col)) {
                ans[index] = 1;
            }
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i >= 0 && i < n && j >= 0 && j < n) {
                        int lampIndex = i * n + j;
                        if (lampIndexes.contains(lampIndex)) {
                            lampIndexes.remove(lampIndex);
                            closeLamp(rowCount, colCount, diagonalLeftCount, diagonalRightCount, i, j);
                        }
                    }
                }
            }
        }
    }

    private boolean check(int row, int col) {
        return rowCount.getOrDefault(row, 0) != 0
                || colCount.getOrDefault(col, 0) != 0
                || diagonalLeftCount.getOrDefault(row - col, 0) != 0
                || diagonalRightCount.getOrDefault(row + col, 0) != 0;
    }

    private void closeLamp(Map<Integer, Integer> rowCount, Map<Integer, Integer> colCount, Map<Integer, Integer> diagonalLeftCount, Map<Integer, Integer> diagonalRightCount, int i, int j) {
        rowCount.put(i, rowCount.getOrDefault(i, 1) - 1);
        colCount.put(j, colCount.getOrDefault(j, 1) - 1);
        diagonalRightCount.put(i + j, diagonalRightCount.getOrDefault(i + j, 1) - 1);
        diagonalLeftCount.put(i - j, diagonalLeftCount.getOrDefault(i - j, 1) - 1);
    }

    private void initLamps(int[][] lamps, int n) {
        for (int index = 0; index < lamps.length; index++) {
            int row = lamps[index][0];
            int col = lamps[index][1];

            rowCount.put(row, rowCount.getOrDefault(row, 0) + 1);
            colCount.put(col, colCount.getOrDefault(col, 0) + 1);
            diagonalLeftCount.put(row - col, diagonalLeftCount.getOrDefault(row - col, 0) + 1);
            diagonalRightCount.put(row + col, diagonalRightCount.getOrDefault(row + col, 0) + 1);
            lampIndexes.add(row * n + col);
        }
    }
}
