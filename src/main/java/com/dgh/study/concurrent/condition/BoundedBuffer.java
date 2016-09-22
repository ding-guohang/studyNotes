package com.dgh.study.concurrent.condition;

import net.jcip.annotations.ThreadSafe;

/**
 * Bounded Buffer
 * made by Object.wait() and Object.notify()
 * <p>
 * 使用条件队列实现的有界缓存
 *
 * @author guohang.ding on 16-9-22
 */
@ThreadSafe
@SuppressWarnings("unused")
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

    public BoundedBuffer(int capacity) {
        super(capacity);
    }

    // 条件谓词 not-full
    public void put(V v) throws InterruptedException {
        synchronized (this) { // lock
            while (isFull()) {
                wait();  // wait
            }

            doPut(v);
            notifyAll();  // why all? -> Condition
        }
    }

    // 条件谓词 not-empty
    public V take() throws InterruptedException {
        synchronized (this) {
            while (isEmpty()) {
                wait();
            }

            V v = doTake();
            notifyAll();
            return v;
        }
    }
}
