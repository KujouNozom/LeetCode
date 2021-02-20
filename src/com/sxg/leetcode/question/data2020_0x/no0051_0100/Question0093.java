package com.sxg.leetcode.question.data2020_0x.no0051_0100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Question0093
 * @Author: Su_N
 * @Date: 2020/5/20 16:54
 * @Description: 回溯
 * 函数两个参数，上一个点的位置preIndex，剩余点的个数pointCount
 * 如果pointCount为0，判断剩余字符串是否和法，合法的话添加到结果集
 * 如果pointCount不为0，从preIndex 遍历剩余的位置，作为下一个点的位置
 * 如果下一个点的位置合法，添加到临时集合，递归
 * 递归结束的时候删除临时集合中的最后一个点（恢复状态）
 * 如果不合法，跳过当前位置
 * <p>
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question0093 {
    public static void main(String[] args) {
        Question0093 demo = new Question0093();
        demo.restoreIpAddresses("25525511135");
        System.out.println();
    }

    private int length;

    private String datas;

    private List<String> result;

    private LinkedList<String> currentResult;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();

        if (s == null || s.length() < 4) {
            return result;
        }

        currentResult = new LinkedList<>();
        datas = s;
        length = datas.length();

        function(-1, 3);

        return result;
    }

    private void function(int preIndex, int pointCount) {
        if (pointCount == 0) {
            if (check(datas.substring(preIndex + 1))) {
                currentResult.add(datas.substring(preIndex + 1));
                result.add(String.join(".", currentResult));
                currentResult.removeLast();
            }
        } else {
            int max = Math.min(length - 1, preIndex + 4);
            for (int index = preIndex + 1; index < max; index++) {
                String current = datas.substring(preIndex + 1, index + 1);
                if (check(current)) {
                    currentResult.add(current);
                    function(index, pointCount - 1);
                    currentResult.removeLast();
                }
            }
        }
    }

    private boolean check(String data) {
        if (data.length() > 3) {
            return false;
        }

        if (data.startsWith("0")) {
            return data.length() == 1;
        }

        return Integer.valueOf(data) <= 255;
    }
}
