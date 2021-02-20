package com.sxg.leetcode.question.data2020_0x.no0251_0300;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Question0284
 * @Author: Su_N
 * @Date: 2020/7/12 17:17
 * @Description:
 */
public class Question0284 {
}

class PeekingIterator implements Iterator<Integer> {
    private List<Integer> datas;

    private int index;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.datas = new ArrayList<>();
        this.index = 0;
        iterator.forEachRemaining((x) -> datas.add(x));
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return datas.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return datas.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < datas.size();
    }
}
