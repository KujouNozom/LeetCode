package com.sxg.leetcode.question.data2020_0x.no0401_0450;

import java.util.*;

/**
 * @ClassName: Question0406
 * @Author: Su_N
 * @Date: 2020/8/4 21:50
 * @Description: 先找出相同身高的人，按照身高排序，身高相同按照前面的人数排序，然后从高往低（因为低身高的插入到前面不会影响到已插入的高身高的人），把同身高的人插入到队列的位置x，x是前面的人数
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Question0406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length != 2) {
            return new int[0][0];
        }

        Map<Integer, List<Integer>> highIndexMap = new TreeMap<>(Comparator.reverseOrder());
        for (int[] data : people) {
            int h = data[0];
            List<Integer> highList = highIndexMap.get(h);
            if (highList == null) {
                highList = new ArrayList<>();
                highIndexMap.put(h, highList);
            }

            highList.add(data[1]);
        }

        List<int[]> answerList = new ArrayList<>();
        highIndexMap.forEach((k, v) -> {
            Collections.sort(v);
            v.forEach(count -> answerList.add(count, new int[]{k, count}));
        });

        return answerList.toArray(new int[people.length][2]);
    }
}
