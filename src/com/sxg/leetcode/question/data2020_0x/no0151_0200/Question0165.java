package com.sxg.leetcode.question.data2020_0x.no0151_0200;

/**
 * @ClassName: Question0165
 * @Author: Su_N
 * @Date: 2020/6/15 23:15
 * @Description: 双指针
 * 两个指针分别指向两个字符串，不断后移判断
 * 165. 比较版本号
 *
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 * . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *
 *
 * 示例 1:
 *
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 *
 * 示例 2:
 *
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 *
 * 示例 4：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 *
 * 示例 5：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 */
public class Question0165 {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int length = nums1.length > nums2.length ? nums1.length : nums2.length;
        int length1 = nums1.length;
        int length2 = nums2.length;

        for (int index = 0; index < length; index++) {
            int value1 = index >= length1 ? 0 : Integer.valueOf(nums1[index]);
            int value2 = index >= length2 ? 0 : Integer.valueOf(nums2[index]);

            if (value1 > value2) {
                return 1;
            }

            if (value1 < value2) {
                return -1;
            }
        }

        return 0;
    }
}
