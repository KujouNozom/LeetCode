package com.sxg.leetcode.question.data2020_10;

import java.util.*;

/**
 * @ClassName: com.sxg.leetcode.question.date2020_10.Question0710
 * @Author: Su_N
 * @Date: 2020/10/14 23:49
 * @Description: 映射
 * 一共n个数字，黑名单有m个，则可使用数字个数n-m，我们随机[0,n-m)
 * 这里面有一些数字在黑名单中，这些数字映射到[n-m,n)中的不在黑名单的数字
 *
 * 710. 黑名单中的随机数
 *
 * 给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。
 *
 * 对它进行优化使其尽量少调用系统方法 Math.random() 。
 *
 * 提示:
 *
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) 不包含 N，详细参见 interval notation 。
 *
 * 示例 1:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * 输出: [null,0,0,0]
 *
 * 示例 2:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * 输出: [null,1,1,1]
 *
 * 示例 3:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 *
 * 示例 4:
 *
 * 输入:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * 输出: [null,1,3,1]
 *
 * 输入语法说明：
 *
 * 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N 和黑名单 B。pick 没有参数，输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 */
public class Question0710 {
    class Solution {
        private Map<Integer, Integer> dict;

        private Random random;

        private int lentgh;

        public Solution(int N, int[] blacklist) {
            random = new Random();
            dict = new LinkedHashMap<>();
            lentgh = N - blacklist.length;

            int m = blacklist.length;
            Set<Integer> sets = new HashSet<>(m);
            for (int index = 0; index < m; index++) {
                sets.add(blacklist[index]);
            }

            int index = N - m;
            for (int temp : blacklist) {
                if (temp < lentgh) {
                    for (; index < N; ) {
                        if (!sets.contains(index)) {
                            dict.put(temp, index++);
                            break;
                        } else {
                            index++;
                        }
                    }
                }
            }
        }

        public int pick() {
            int num = random.nextInt(lentgh);
            return dict.getOrDefault(num, num);
        }
    }
}
