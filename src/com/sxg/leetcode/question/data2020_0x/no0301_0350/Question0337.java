package com.sxg.leetcode.question.data2020_0x.no0301_0350;

import com.sxg.leetcode.entity.TreeNode;

/**
 * @ClassName: Question0337
 * @Author: Su_N
 * @Date: 2020/7/23 22:30
 * @Description: 动态规划
 * 带状态的动态规划
 * dp(i)[0] 表示当前节点不偷的情况下，获取最多的钱，dp(i)[1] 表示当前节点偷的情况下，获取最多的钱
 *
 * dp(i)[0]：当前节点不偷，所以最多的钱是左右孩子节点最大值之和(偷和不偷都行)
 * dp(i)[0] = max(dp(i-left)[0],dp(i-left)[1]) + max(dp(i-right)[0],dp(i-right)[1])
 * dp(i)[1]: 当前节点偷，所以最多的钱是左右孩子节点不偷之和加上自身的值
 * dp(i)[1] = dp(i-left)[0] + dp(i-right)[0] + val(i)
 *
 * 使用递归，当一个节点为null的时候返回0
 *
 * 337. 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class Question0337 {
    public int rob(TreeNode root) {
        int[] max = getMax(root);
        return Math.max(max[0], max[1]);
    }

    private int[] getMax(TreeNode root) {
        int[] max = new int[2];
        if (root == null) {
            return max;
        }

        int[] maxLeft = getMax(root.left);
        int[] maxRight = getMax(root.right);

        max[0] = Math.max(maxLeft[0], maxLeft[1]) + Math.max(maxRight[0], maxRight[1]);
        max[1] = maxLeft[0] + maxRight[0] + root.val;

        return max;
    }
}
