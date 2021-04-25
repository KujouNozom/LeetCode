package com.sxg.leetcode.question.data2020_0x.no0151_0200;

import java.util.Arrays;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_0x.no0151_0200.Question0174
 * @Author: Su_N
 * @Date: 2020/11/3 23:02
 * @Description: 动态规划
 * 需要从终点往起点倒退，dp[i][j]表示从 i，j到终点的最小起始值
 * dp[i][j] = max(min(dp[i+1][j],dp[i][j+1])- dungeon[i][j],1)
 * min(dp[i+1][j],dp[i][j+1])- dungeon[i][j] 表示，i,j下一步的格子到终点的最小声明，如果是负数，说明有富裕的生命值
 * 但是这些富裕的生命值没有用，因为这不影响之前的需要的生命值（之前如果是生命值降到0，后面再多也没用），所以当后面数值小于0 的时候，取1
 * 注意初始值为无效值，一个很大的值
 *
 *
 * 174. 地下城游戏
 *
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 *
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * -2 (K) 	-3 	3
 * -5 	-10 	1
 * 10 	30 	-5 (P)
 *
 *
 *
 * 说明:
 *
 * 骑士的健康点数没有上限。
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class Question0174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }


}
