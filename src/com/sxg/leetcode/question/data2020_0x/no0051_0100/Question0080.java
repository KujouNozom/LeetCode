package com.sxg.leetcode.question.data2020_0x.no0051_0100;

/**
 * @ClassName: Question0080
 * @Author: Su_N
 * @Date: 2020/5/13 19:00
 * @Description: 双指针法、覆盖
 * 使用两个指针，一个 index 指向当前遍历的元素,一个 indexResult 指向当前需要替换的元素
 * 设置计数值 count 初始为1，
 * 1.index 从1开始遍历数组，当nums[index] == nums[index-1]的时候 count++
 * 2.如果 count <= 2,使用 nums[index] 覆盖 nums[indexResult],index++,indexResult++
 * 3.如果 count > 2,index++,indexResult 不变
 * 4.当 nums[index] != nums[index-1] 的时候,使用 nums[index] 覆盖 nums[indexResult],index++,indexResult++,count =1
 * 5.最终返回 indexResult 的值，是新数组的长度
 * <p>
 * 80. 删除排序数组中的重复项 II
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class Question0080 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 1;
        int indexResult = 1;
        int count = 1;


        for (; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                count++;
                if (count <= 2) {
                    nums[indexResult] = nums[index];
                    indexResult++;
                }
            } else {
                nums[indexResult] = nums[index];
                indexResult++;
                count = 1;
            }
        }

        return indexResult;
    }
}
