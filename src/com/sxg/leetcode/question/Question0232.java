package com.sxg.leetcode.question;

import java.util.Stack;

/**
 * @ClassName: Question0232
 * @Author: Su_N
 * @Date: 2021/3/5 21:59
 * @Description: 232. 用栈实现队列 [栈]
 */
public class Question0232 {
    class MyQueue {
        private Stack<Integer> stackInput;
        private Stack<Integer> stackOutput;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackInput = new Stack<>();
            stackOutput = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (stackInput.isEmpty()) {
                while (!stackOutput.isEmpty()) {
                    stackInput.push(stackOutput.pop());
                }
            }
            stackInput.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!stackInput.isEmpty()) {
                while (!stackInput.isEmpty()) {
                    stackOutput.push(stackInput.pop());
                }
            }
            return stackOutput.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!stackInput.isEmpty()) {
                while (!stackInput.isEmpty()) {
                    stackOutput.push(stackInput.pop());
                }
            }
            return stackOutput.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stackInput.isEmpty() && stackOutput.empty();
        }
    }
}
