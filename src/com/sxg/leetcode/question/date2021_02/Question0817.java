package com.sxg.leetcode.question;

import java.util.HashSet;
import java.util.Set;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0817
 * @Author: Su_N
 * @Date: 2021/2/3 13:47
 * @Description: 817. 链表组件
 */
public class Question0817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> gIndexes = new HashSet();
        for (int value : G) {
            gIndexes.add(value);
        }

        int ans = 0;
        // 是否正在连续队列
        boolean flag = false;
        while (head != null) {
            int value = head.val;
            if (flag && !gIndexes.contains(value)) {
                ans++;
                flag = false;
            } else if (gIndexes.contains(value)) {
                flag = true;
            }
            head = head.next;
        }

        return flag ? ans + 1 : ans;
    }
}
