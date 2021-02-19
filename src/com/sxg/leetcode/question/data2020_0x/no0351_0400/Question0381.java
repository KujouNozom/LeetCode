package com.sxg.leetcode.question.data2020_0x.no0351_0400;

import java.util.*;

/**
 * @ClassName: Question0381
 * @Author: Su_N
 * @Date: 2020/10/31 19:40
 * @Description: 使用一个Map最初索引，一个list存储数据，每次删除元素，将元素和最后一个元素交换，然后删除最后一个元素
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 *
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 */
public class Question0381 {
    class RandomizedCollection {
        private Map<Integer, Set<Integer>> indexes;

        private List<Integer> datas;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            this.indexes = new HashMap<>();
            this.datas = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            Set<Integer> index = indexes.getOrDefault(val, new HashSet<>());
            if (!index.add(datas.size())) {
                return false;
            }
            indexes.put(val, index);
            datas.add(val);

            return index.size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            Set<Integer> index = indexes.get(val);
            if (index == null) {
                return false;
            }

            // 获取删除元素索引
            int i = index.iterator().next();
            // 将删除元素和数据集合最后一个元素交换
            int lastVal = datas.get(datas.size() - 1);
            datas.set(i, lastVal);

            //删除元素index
            index.remove(i);

            // 删除待删除元素的索引
            Set<Integer> iIndex = indexes.get(val);
            iIndex.remove(i);

            // 修改最后元素的索引
            indexes.get(lastVal).remove(datas.size() - 1);
            if (i != datas.size() - 1) {
                indexes.get(lastVal).add(i);
            }

            if (iIndex.size() == 0) {
                indexes.remove(val);
            }
            datas.remove(datas.size() - 1);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            Random random = new Random();
            return datas.get(random.nextInt(datas.size()));
        }
    }
}
