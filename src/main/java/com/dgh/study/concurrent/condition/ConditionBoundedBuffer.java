package com.dgh.study.concurrent.condition;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于Condition的条件队列 有界缓存
 * 在唤醒和等待的机制上有所提升
 *
 * @author guohang.ding on 16-9-22
 */
@SuppressWarnings("unused")
@ThreadSafe
public class ConditionBoundedBuffer<V> {

    protected final Lock lock = new ReentrantLock();
    protected final Condition notEmptyCondition = lock.newCondition();
    protected final Condition notFullCondition = lock.newCondition();

    @GuardedBy("lock")
    protected final V[] fields;
    @GuardedBy("lock")
    private int tail, head, count;

    @SuppressWarnings("unchecked")
    public ConditionBoundedBuffer(int capacity) {
        fields = (V[]) new Object[capacity];
    }

    public void put(V v) throws InterruptedException {
        lock.lock();
        try {
            while (count == fields.length) {
                notFullCondition.await();
            }

            fields[tail] = v;
            if (++tail == fields.length) {
                tail = 0;
            }
            ++count;

            notEmptyCondition.signal(); //显然满足单个唤醒的2个条件
        } finally {
            lock.unlock();
        }
    }

    public V take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmptyCondition.await();
            }

            V v = fields[head];
            fields[head] = null;
            if (++head == fields.length) {
                head = 0;
            }
            --count;

            notFullCondition.signal();
            return v;
        } finally {
            lock.unlock();
        }
    }
}
