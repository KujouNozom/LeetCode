package com.sxg.leetcode.question.data2020_0x.no0051_0100;

/**
 * @ClassName: Question0075
 * @Author: Su_N
 * @Date: 2020/5/12 20:02
 * @Description: 荷兰国旗问题，双指针
 * 使用两个指针
 * 一个保存0的位置，初始为0，每次交换之后，移动到右侧下一个不为0的位置
 * （注意0指针可能移动超过当前处理元素指针 当前处理元素指针也要判断是否需要移动）
 * 一个保存2的位置，初始为length-1,每次交换之后移动到左侧下一个不为2的位置
 * 再使用一个指针指向当前元素，当当前元素不为1的时候，交换元素，为1的时候移动到下一个元素
 * 注意交换完成之后，需要判断交换完成后的值是不是1，如果不是，那么先不要移动指针，继续交换，如果是1，移动指针
 * <p>
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Question0075 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int index0 = 0;
        int index2 = nums.length - 1;

        for (int index = 0; index <= index2; ) {
            if (nums[index] == 0) {
                swap(nums, index0, index);
                while (index0 < nums.length && nums[index0] == 0) {
                    index0++;
                }
                if (index0 > index) {
                    index = index0;
                }
                continue;
            }

            if (nums[index] == 1) {
                index++;
                continue;
            }

            if (nums[index] == 2) {
                swap(nums, index2, index);
                while (index2 >= 0 && nums[index2] == 2) {
                    index2--;
                }
                continue;
            }
        }

    }

    private void swap(int[] datas, int i, int j) {
        int temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }
}
