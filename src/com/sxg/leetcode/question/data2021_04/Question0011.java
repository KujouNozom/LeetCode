package com.sxg.leetcode.question.data2021_04;

import java.util.Scanner;

/**
 * @ClassName: Question0011
 * @Author: Su_N
 * @Date: 2020/4/26 23:46
 * @Description: 11. 盛最多水的容器
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
