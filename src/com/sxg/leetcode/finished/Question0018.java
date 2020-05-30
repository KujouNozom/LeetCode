package com.sxg.leetcode.finished;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Question0018
 * @Author: Su_N
 * @Date: 2020/4/27 21:41
 * @Description:双指针,类似0015,多加一层循环 18. 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
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
