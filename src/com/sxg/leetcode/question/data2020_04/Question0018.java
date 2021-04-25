package com.sxg.leetcode.question.data2020_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Question0018
 * @Author: Su_N
 * @Date: 2020/4/27 21:41
 * @Description: 18. 四数之和 [双指针,类似0015,多加一层循环]
 */
public class Question0018 {
    public static void main(String[] args) {
        Question0018 demo = new Question0018();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split(",");
            Integer target = Integer.valueOf(scanner.nextLine());

            int[] datas = new int[inputs.length];
            for (int index = 0; index < datas.length; index++) {
                datas[index] = Integer.valueOf(inputs[index]);
            }

            System.out.println(demo.fourSum(datas, target));
        }
        scanner.close();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int preTail = nums[0] - 1;
        for (int indexTail = 0; indexTail <= nums.length - 4; indexTail++) {
            if (preTail == nums[indexTail]) {
                continue;
            }
            preTail = nums[indexTail];

            int pre = nums[indexTail] - 1;
            for (int index = indexTail + 1; index <= nums.length - 3; index++) {
                if (pre == nums[index]) {
                    continue;
                }
                pre = nums[index];

                int left = index + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int addResult = preTail + pre + nums[left] + nums[right];
                    if (addResult == target) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(preTail, pre, nums[left], nums[right]));
                        result.add(temp);
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        continue;
                    }

                    if (addResult > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

        }
        return result;
    }
}
