package com.sxg.leetcode.question.data2020_10;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0845
 * @Author: Su_N
 * @Date: 2020/10/25 10:12
 * @Description: 双指针
 * 当遇到一个节点左边大于当前节点，右边小于当前节点的时候说明是山脚，这个时候该指针不动，使用一个新的指针
 * 当新指针继续上升的到时候不需要操作，当指针下降的时候，这个时候两个指针中间的部分肯定是山脉，记录最大长度，当遇到平行的时候重置起点设置为无效值
 * 重复执行直到，数组遍历完成
 * 845. 数组中的最长山脉
 *
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 *
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 *
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Question0845 {
    public static void main(String[] args) {
        new Question0845().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5});
    }

    public int longestMountain(int[] A) {
        int max = 0;
        int start = -1;

        for (int index = 0; index < A.length - 1; index++) {
            if (A[index] < A[index + 1]) {
                if (index == 0 || A[index - 1] >= A[index]) {
                    start = index;
                }
            } else if (A[index] > A[index + 1]) {
                if (start != -1) {
                    max = Math.max(max, index + 1 - start + 1);
                }
            } else {
                start = -1;
            }
        }

        return max;
    }
}
