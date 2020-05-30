package com.sxg.leetcode.finished;

import java.util.Scanner;

/**
 * @ClassName: Question0011
 * @Author: Su_N
 * @Date: 2020/4/26 23:46
 * @Description: 11. 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（下标1-8）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class Question0011 {
    public static void main(String[] args) {
        Question0011 demo = new Question0011();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split(",");
            int[] height = new int[inputs.length];
            for (int index = 0; index < height.length; index++) {
                height[index] = Integer.valueOf(inputs[index]);
            }

            System.out.println(demo.maxArea(height));
        }
        scanner.close();
    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = 0;


        while (left < right) {
            int minhHight = Math.min(height[left], height[right]);
            max = Math.max(max, minhHight * (right - left));
            if (height[left] < height[right]) {
                while (left < right && height[left] <= minhHight) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= minhHight) {
                    right--;
                }
            }
        }

        return max;
    }
}
