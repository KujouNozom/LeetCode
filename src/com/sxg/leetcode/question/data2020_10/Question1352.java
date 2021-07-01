package com.sxg.leetcode.question.data2020_10;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question1352
 * @Author: Su_N
 * @Date: 2020/10/17 20:48
 * @Description: 前缀和
 * 维护一个队列nums，保存前n个元素的乘积，当需要计算后k个元素的乘积的时候，使用整个数组的乘积nums[n]/前n-k个元素的乘积nums[n-k]
 * 注意的是，出现0的时候，我们清空数组，因为出现0的时候，前面的元素没有用了，乘数中出现0，乘积必定为0
 * 当get的时候如果数组长度小于k,说明0出现过。直接返回0，否则返回num[n]/nums[n-k];
 * 我们添加一个1，让第一个元素添加的时候比较好添加，
 * 1352. 最后 K 个数的乘积
 *
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 *
 * 1. add(int num)
 *
 * 将数字 num 添加到当前数字列表的最后面。
 *
 * 2. getProduct(int k)
 *
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 *
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 *
 * 输出：
 * [null,null,null,null,null,null,20,40,0,null,32]
 *
 * 解释：
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
 * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
 *
 *
 *
 * 提示：
 *
 * add 和 getProduct 两种操作加起来总共不会超过 40000 次。
 * 0 <= num <= 100
 * 1 <= k <= 40000
 */
public class Question1352 {
    public static void main(String[] args) {
        ProductOfNumbers demo = new ProductOfNumbers();
        demo.add(3);
        demo.add(0);
        demo.add(2);
        demo.add(5);
        demo.add(4);
        demo.getProduct(2);
        demo.getProduct(3);
        demo.getProduct(4);
        demo.add(8);
        demo.getProduct(2);

    }

    static class ProductOfNumbers {
        private List<Integer> nums;


        public ProductOfNumbers() {
            nums = new ArrayList<>();
            nums.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                nums = new ArrayList<>();
                nums.add(1);
            } else {
                int currentSount = nums.get(nums.size() - 1) * num;
                nums.add(currentSount);
            }
        }

        public int getProduct(int k) {
            int size = nums.size() - 1;

            if (size < k) {
                return 0;
            }

            return nums.get(size) / nums.get(size - k);
        }
    }
}
