package com.dgh.study.concurrent.condition;

import com.dgh.study.concurrent.exceptions.BufferEmptyException;
import com.dgh.study.concurrent.exceptions.BufferFullException;
import net.jcip.annotations.ThreadSafe;

/**
 * 最暴躁的状态依赖管理方式——不满足条件谓词，就抛出异常
 * <p>
 * 事实上这增加了调用方的逻辑复杂度
 * 而且对缓存来说，缓存满了或者空了，实际上是一个正常的现象，并不算异常
 *
 * 这种方式，将状态依赖的控制交给了调用者，容易丢失功能，例如FIFO
 *
 * @author guohang.ding on 16-9-22
 */
@ThreadSafe
@SuppressWarnings("unused")
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
