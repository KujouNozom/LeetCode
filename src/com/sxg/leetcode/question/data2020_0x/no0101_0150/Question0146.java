package com.sxg.leetcode.question.data2020_0x.no0101_0150;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Question0146
 * @Author: Su_N
 * @Date: 2020/6/8 22:58
 * @Description: 使用一个队列，一个Map实现，不要使用自带的 LinkHashMap 实现
 * 我也使用了自带的类，用自己实现的链表更好
 * 146. LRU缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 缓存容量)
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class Question0146 {
    public static void main(String[] args) {
        LRUCache demo = new LRUCache(2);
        demo.put(1, 1);
        demo.put(2, 2);
        System.out.println(demo.get(1));
        demo.put(3, 3);
        System.out.println(demo.get(2));
        demo.put(4, 4);
        System.out.println(demo.get(1));
        System.out.println(demo.get(3));
        System.out.println(demo.get(4));
    }


}

class LRUCache {
    private Deque<Integer> queue;

    private Map<Integer, Integer> datas;

    private int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.queue = new LinkedList<>();
        this.datas = new HashMap<>(size);
    }

    public int get(int key) {
        if (queue.contains(key)) {
            queue.remove(key);
            queue.addFirst(key);
            return datas.get(key);
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (queue.contains(key)) {
            queue.remove(key);
        } else if (queue.size() == size) {
            datas.remove(queue.pollLast());
        }
        queue.addFirst(key);
        datas.put(key, value);
    }
}