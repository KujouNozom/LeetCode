package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: Question1140
 * @Author: Su_N
 * @Date: 2020/6/4 22:58
 * @Description: 动态规划，深搜
 * dp[i][M] 记录去了i堆石子的时候对应M A可取的最大值
 * <p>
 * 递归方法
 * 暴力法求A取 1-2M石子到时候 L能取的最多石子树同样使用这个递归方法
 * 取这些值中最小的值，L取的最少，A取的就多
 * <p>
 * 1140. 石子游戏 II
 * <p>
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 * <p>
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * <p>
 * 游戏一直持续到所有石子都被拿走。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 */
public class Question1140 {
    private int[] sumArray;

    private int length;

    private int[][] dp;

    public int stoneGameII(int[] piles) {
        if (piles.length <= 1) {
            return piles[0];
        }
        length = piles.length;
        sumArray = new int[length];

        sumArray[length - 1] = piles[length - 1];
        for (int index = length - 2; index >= 0; index--) {
            sumArray[index] = sumArray[index + 1] + piles[index];
        }

        dp = new int[length][length / 2 + 1];

        return getMax(1, 0);
    }


    private int getMax(int M, int getCount) {
        if (getCount == length) {
            return 0;
        }

        if (M * 2 >= length - getCount) {
            return sumArray[getCount];
        }

        if (dp[getCount][M] != 0) {
            return dp[getCount][M];
        }

        int min = Integer.MAX_VALUE;
        for (int X = 1; X <= 2 * M; X++) {
            int tempM = Math.max(X, M);
            int tempGetCount = getCount + X;
            min = Math.min(min, getMax(tempM, tempGetCount));
        }

        dp[getCount][M] = sumArray[getCount] - min;
        return dp[getCount][M];
    }
}
