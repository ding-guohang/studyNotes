package com.dgh.study.concurrent.condition;

import com.dgh.study.concurrent.exceptions.BufferEmptyException;
import com.dgh.study.concurrent.exceptions.BufferFullException;
import net.jcip.annotations.ThreadSafe;

/**
 * 最暴躁的状态依赖管理方式
 * <p>
 * 事实上这增加了调用方的逻辑复杂度
 * 而且对缓存来说，缓存满了或者空了，实际上是一个正常的现象，并不算异常
 *
 * @author guohang.ding on 16-9-22
 */
@ThreadSafe
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws BufferFullException {
        if (isFull()) {
            throw new BufferFullException();
        }

        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty()) {
            throw new BufferEmptyException();
        }

        return doTake();
    }

}
