package com.sxg.leetcode.question;

import java.util.PriorityQueue;

/**
 * @ClassName: Question0703
 * @Author: Su_N
 * @Date: 2021/2/11 9:05
 * @Description: 703. 数据流中的第 K 大元素
 */
public class Question0703 {
    class KthLargest {
        private PriorityQueue<Integer> queue;

        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>();

            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.offer(val);
            } else if (queue.size() == k && val > queue.peek()) {
                queue.poll();
                queue.offer(val);
            }

            return queue.peek();
        }
    }
}

