package com.sxg.leetcode.question.data2020_0x.面试题;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: com.sxg.leetcode.question.data2020_0x.面试题.Question16_25
 * @Author: Su_N
 * @Date: 2020/10/11 12:18
 * @Description:
 */
public class Question16_25 {
    class LRUCache {

        private Map<Integer, Integer> datas;

        private int maxSize;

        public LRUCache(int capacity) {
            datas = new LinkedHashMap<>(capacity);
            maxSize = capacity;
        }

        public int get(int key) {
            if (datas.containsKey(key)) {
                int value = datas.get(key);
                datas.remove(key);
                datas.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (datas.containsKey(key)) {
                datas.remove(key);
                datas.put(key, value);
            } else if (datas.size() == maxSize) {
                int index = datas.keySet().iterator().next();
                datas.remove(index);
                datas.put(key, value);
            } else {
                datas.put(key, value);
            }
        }
    }
}
