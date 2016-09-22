package com.dgh.study.concurrent.condition;

import net.jcip.annotations.ThreadSafe;

/**
 * 使用轮询+休眠 勉强地实现阻塞
 *
 * @author guohang.ding on 16-9-22
 */
@ThreadSafe
@SuppressWarnings("unused")
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public SleepyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public V take() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isEmpty()) {
                    return doTake();
                }
            }
            Thread.sleep(5000);
        }
    }

    public void put(V v) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (!isFull()) {
                    doPut(v);
                    return;
                }
            }
            Thread.sleep(5000);
        }
    }
}
