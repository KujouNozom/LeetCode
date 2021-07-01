package com.sxg.leetcode.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Question0765
 * @Author: Su_N
 * @Date: 2021/2/14 21:35
 * @Description: 765. 情侣牵手
 */
public class Question0765 {
    public static void main(String[] args) {
        Question0765 demo = new Question0765();
        demo.minSwapsCouples(new int[]{6, 2, 1, 7, 4, 5, 3, 8, 0, 9
        });
    }

    public int minSwapsCouples(int[] row) {
        int length = row.length;
        int half = length / 2;
        UnionFind unionFind = new UnionFind(half);

        for (int index = 0; index < half; index++) {
            unionFind.union(row[index * 2] / 2, row[index * 2 + 1] / 2);
        }

        return unionFind.getAns();
    }

    class UnionFind {
        private int[] parents;

        public UnionFind(int n) {
            this.parents = new int[n];
            for (int index = 0; index < n; index++) {
                parents[index] = index;
            }
        }

        public int find(int x) {
            int parent_x = parents[x];
            if (parent_x != x) {
                parents[x] = find(parent_x);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            parents[find(x)] = find(y);
        }

        public int getAns() {
            Map<Integer, Integer> indexes = new HashMap<>();
            for (int index : parents) {
                int parent = find(index);
                indexes.put(parent, indexes.getOrDefault(parent, 0) + 1);
            }

            int ans = 0;
            for (int count : indexes.values()) {
                ans += count - 1;
            }

            return ans;
        }
    }
}


