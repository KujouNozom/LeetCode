package com.sxg.leetcode.question.data2021_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Question0015
 * @Author: Su_N
 * @Date: 2020/4/27 21:02
 * @Description: 15. 三数之和 [双指针法]
 */
public class Question0015 {
    public static void main(String[] args) {
        Question0015 demo = new Question0015();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split(",");
            int[] datas = new int[inputs.length];
            for (int index = 0; index < datas.length; index++) {
                datas[index] = Integer.valueOf(inputs[index]);
            }

            System.out.println(demo.threeSum(datas));
        }
        scanner.close();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int pre = nums[0] - 1;
        for (int index = 0; index <= nums.length - 3; index++) {
            if (pre == nums[index]) {
                continue;
            }
            pre = nums[index];

            if (nums[index] > 0) {
                break;
            }

            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                int addResult = pre + nums[left] + nums[right];
                if (addResult == 0) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(pre, nums[left], nums[right]));
                    result.add(temp);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    continue;
                }

                if (addResult > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
