package com.sxg.leetcode.question.no0001_0050;

import com.sxg.leetcode.entity.ListNode;

import java.util.Scanner;

/**
 * @ClassName: Question0080
 * @Author: Su_N
 * @Date: 2020/4/26 22:13
 * @Description: 2. 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
            int addResult = (l1 == null ? 0 : l1.val)
                    + (l2 == null ? 0 : l2.val) + carry;

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
