package com.sxg.leetcode.question.data2021_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Question0047
 * @Author: Su_N
 * @Date: 2020/4/28 13:40
 * @Description: 47. 全排列 II [回溯]
 */
public class Question0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> remain = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            remain.add(nums[index]);
        }
        Collections.sort(remain);

        function(result, new ArrayList<>(), remain);
        return result;
    }

    private void function(List<List<Integer>> result, List<Integer> current, List<Integer> remain) {
        if (remain.isEmpty()) {
            result.add(current);
        } else {
            int pre = remain.get(0) - 1;
            for (Integer temp : remain) {
                if (temp == pre) {
                    continue;
                }

                List<Integer> tempRemain = new ArrayList<>(remain);
                tempRemain.remove(temp);

                List<Integer> tempCurrent = new ArrayList<>(current);
                tempCurrent.add(temp);

                function(result, tempCurrent, tempRemain);
                pre = temp;
            }
        }
    }
}
