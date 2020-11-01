package com.sxg.leetcode.question.date2020_10;

import java.util.Arrays;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1024
 * @Author: Su_N
 * @Date: 2020/10/24 13:56
 * @Description: 贪心算法
 * 遍历所有节点，处理数据，右界大于T的转换为T，左边界大于T的删除，相同左边界的值取右界最大的
 * 遍历当前所能到达的所有位置的点（左边界可达），取这些点再次能到达的最远右边界的点；一直执行下去，直到最长片段
 *
 * 1024. 视频拼接
 *
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 *
 * 示例 2：
 *
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 *
 * 示例 3：
 *
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 *
 * 示例 4：
 *
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 *
 *
 *
 * 提示：
 *
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 */
public class Question1024 {
    public static void main(String[] args) {
        new Question1024().videoStitching(new int[][]{{3, 12}, {7, 14}, {9, 14}, {12, 15}, {0, 9}, {4, 14}, {2, 7}, {1, 11}}, 10);
    }

    public int videoStitching(int[][] clips, int T) {
        int[] indexes = getIndexesMap(T, clips);
        int max = 0;
        int start = -1;
        int count = 0;

        while (max != T) {
            int index = start + 1;
            start = max;
            for (; index <= start; index++) {
                max = Math.max(indexes[index], max);
            }

            if (start == max) {
                return -1;
            } else {
                count++;
            }
        }

        return count;
    }

    private int[] getIndexesMap(int n, int[][] clips) {
        int[] indexes = new int[n + 1];
        Arrays.fill(indexes, -1);
        for (int index = 0; index < clips.length; index++) {
            if (clips[index][0] <= n) {
                int left = clips[index][0];
                int right = Math.min(clips[index][1], n);
                indexes[left] = Math.max(indexes[left], right);
            }
        }

        return indexes;
    }
}
