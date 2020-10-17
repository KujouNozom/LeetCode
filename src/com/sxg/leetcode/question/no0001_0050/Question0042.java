package com.sxg.leetcode.question.no0001_0050;

import java.util.Scanner;

/**
 * @ClassName: Question0042
 * @Author: Su_N
 * @Date: 2020/4/27 0:00
 * @Description: 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Question0042 {
    public static void main(String[] args) {
        Question0042 demo = new Question0042();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split(",");
            int[] height = new int[inputs.length];
            for (int index = 0; index < height.length; index++) {
                height[index] = Integer.valueOf(inputs[index]);
            }

            System.out.println(demo.trap(height));
        }
        scanner.close();
    }


    public int trap(int[] height) {
        int maxIndex = -1;
        int max = 0;
        for (int index = 0; index < height.length; index++) {
            if (height[index] > max) {
                max = height[index];
                maxIndex = index;
            }
        }

        int rseult = 0;

        int currentMaxIndex = maxIndex - 1;
        int nextMaxIndex = currentMaxIndex;
        if (currentMaxIndex > 0) {
            while (currentMaxIndex > 0) {
                int nextMax = height[currentMaxIndex];
                for (int i = currentMaxIndex; i >= 0; i--) {
                    if (height[i] >= nextMax) {
                        nextMax = height[i];
                        nextMaxIndex = i;
                    }
                }

                for (int j = nextMaxIndex + 1; j <= currentMaxIndex; j++) {
                    rseult += (nextMax - height[j]);
                }

                currentMaxIndex = nextMaxIndex - 1;
                nextMaxIndex = currentMaxIndex;
            }
        }


        currentMaxIndex = maxIndex + 1;
        nextMaxIndex = currentMaxIndex;
        if (currentMaxIndex < height.length - 1) {
            while (currentMaxIndex < height.length - 1) {
                int nextMax = height[currentMaxIndex];

                for (int i = currentMaxIndex; i < height.length; i++) {
                    if (height[i] >= nextMax) {
                        nextMax = height[i];
                        nextMaxIndex = i;
                    }

                }
                for (int j = currentMaxIndex; j <= nextMaxIndex; j++) {
                    rseult += (nextMax - height[j]);
                }
                currentMaxIndex = nextMaxIndex + 1;
                nextMaxIndex = currentMaxIndex;
            }
        }

        System.gc();
        return rseult;
    }
}
