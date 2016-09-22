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
            while (isEmpty()) { // use 'while' instead of 'if' -> check conditions after notified
                wait(); // instead of 'do-while' -> check before wait -> may signal loss
            }

            V v = doTake();
            notifyAll();
            return v;
        }
    }

    /**
     * 不那么保守地唤醒
     * 显而易见的是，只有当缓存从空变为非空时，才需要唤醒take；从满变为不满时，才需要唤醒put
     */
    public synchronized void newPut(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }

        boolean wasEmpty = isEmpty();
        doPut(v);
        if (wasEmpty) {
            notifyAll();
        }
    }
}
