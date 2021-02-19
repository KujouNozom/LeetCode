package com.sxg.leetcode.question.data2020_0x.no0251_0300;

/**
 * @ClassName: Question0275
 * @Author: Su_N
 * @Date: 2020/7/9 22:40
 * @Description: 使用二分查找
 * 数组长度是 length ，当前索引是 mid
 * 查找条件是
 * 1.citations[mid] == length - mid 得到答案，返回 length - mid
 * 2.citations[mid] > length - mid 答案在左侧，修改左右边界
 * 3.citations[mid] < length - mid 答案在右侧，修改左右边界
 *
 *
 * 275. H指数 II
 *
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 *
 *
 *
 * 示例:
 *
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 * 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *
 *
 *
 * 说明:
 *
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 *
 *
 *
 * 进阶：
 *
 * 这是 H指数 的延伸题目，本题中的 citations 数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 */
public class Question0275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int length = citations.length;
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] == length - mid) {
                return length - mid;
            }

            if (citations[mid] > length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return length - left;
    }
}
