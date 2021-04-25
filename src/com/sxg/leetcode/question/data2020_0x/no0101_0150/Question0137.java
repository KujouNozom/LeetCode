package com.sxg.leetcode.question.data2020_0x.no0101_0150;

/**
 * @ClassName: Question0137
 * @Author: Su_N
 * @Date: 2020/6/2 23:01
 * @Description: 位运算
 * 开始我使用set存储数字。求和 * 3 - 原始集合求和，然后/2得到结果....
 * <p>
 * 后来开了大神操作，可以用位运算 XOR
 * 0 XOR A = A
 * A XOR A = 0
 * <p>
 * 一次三次都会使 A 保持原值，因此除了temp1需要多一个临时变量temp2存储出现两次的情况
 * 当temp2未变的时候 改变temp1(这个是第一次出现的情况)
 * 当temp1未变的时候 改变temp2(出现两次的情况，因为出现两次temp1才会是未变的，这个时候temp2已经改变，出现第三次的时候temp1也不会变了)
 * <p>
 * 137. 只出现一次的数字 II
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class Question0137 {
    public int singleNumber(int[] nums) {
        int temp1 = 0;
        int temp2 = 0;

        for (int temp : nums) {
            temp1 = ~temp2 & (temp ^ temp1);
            temp2 = ~temp1 & (temp ^ temp2);
        }

        return temp1;
    }
}
