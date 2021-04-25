package com.sxg.leetcode.question.data2020_0x.no0151_0200;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: Question0179
 * @Author: Su_N
 * @Date: 2020/6/17 22:06
 * @Description: 排序
 * 两个数比较的规则是，a链接b>b链接a的话，a>b
 * 排序之后连接在一起就是最大值
 * 179. 最大数
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Question0179 {
    public String largestNumber(int[] nums) {
        List<String> temps = Arrays.stream(nums).boxed().map(Object::toString).sorted((a, b) -> (b + a).compareTo(a + b)).collect(Collectors.toList());
        String result = String.join("", temps);
        return result.startsWith("0") ? "0" : result;
    }
}

