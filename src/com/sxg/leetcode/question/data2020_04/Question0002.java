package com.sxg.leetcode.question.data2020_04;

import java.util.Scanner;

import com.sxg.leetcode.entity.ListNode;

/**
 * @ClassName: Question0080
 * @Author: Su_N
 * @Date: 2020/4/26 22:13
 * @Description: 2. 两数相加
 */
public class Question0002 {
    public static void main(String[] args) {
        Question0002 demo = new Question0002();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] datas1 = scanner.nextLine().split(",");
            String[] datas2 = scanner.nextLine().split(",");

            ListNode listNode1Head = new ListNode(-1);
            ListNode listNode2Head = new ListNode(-1);

            getListNode(datas1, listNode1Head);
            getListNode(datas2, listNode2Head);

            ListNode result = demo.addTwoNumbers(listNode1Head.next, listNode2Head.next);

            System.out.println(getOutput(result));
        }
        scanner.close();
    }

    private static StringBuilder getOutput(ListNode result) {
        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            stringBuilder.append(result.val).append(",");
            result = result.next;
        }

        if (stringBuilder.length() > 0) {
            stringBuilder = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode reultHead = new ListNode(-1);
        ListNode reultCurrent = reultHead;

        while (l1 != null || l2 != null || carry != 0) {
            int addResult = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            ListNode tempNode = new ListNode(addResult % 10);
            carry = addResult / 10;

            reultCurrent.next = tempNode;
            reultCurrent = reultCurrent.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return reultHead.next;
    }

    private static void getListNode(String[] datas1, ListNode listNode2Head) {
        ListNode listNodex2Current = listNode2Head;
        for (String temp : datas1) {
            ListNode tempNode = new ListNode(Integer.valueOf(temp));
            listNodex2Current.next = tempNode;
            listNodex2Current = listNodex2Current.next;
        }
    }
}
