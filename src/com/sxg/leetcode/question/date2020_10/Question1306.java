package com.sxg.leetcode.question.date2020_10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Question1306
 * @Author: Su_N
 * @Date: 2020/4/28 14:28
 * @Description: 深度遍历
 * 1306. 跳跃游戏 III
 * <p>
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 */
public class Question1306 {
    public static void main(String[] args) {
        Question1306 demo = new Question1306();
        System.out.println(demo.canReach(new int[]{0, 3, 0, 6, 3, 3, 4}, 6));
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];

        Queue<Integer> visitQueue = new LinkedList<>();

        visitQueue.offer(start);
        visited[start] = true;

        int length = arr.length;
        while (!visitQueue.isEmpty()) {
            int current = visitQueue.poll();
            int indexAdd = current + arr[current];
            int indexSub = current - arr[current];
            if (indexAdd < length && arr[indexAdd] == 0) {
                return true;
            }

            if (indexSub >= 0 && arr[indexSub] == 0) {
                return true;
            }

            if (indexAdd < length && !visited[indexAdd]) {
                visited[indexAdd] = true;
                visitQueue.offer(indexAdd);
            }

            if (indexSub >= 0 && !visited[indexSub]) {
                visited[indexSub] = true;
                visitQueue.offer(indexSub);
            }
        }

        return false;
    }
}
