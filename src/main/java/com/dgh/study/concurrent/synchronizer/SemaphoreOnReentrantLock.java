package com.dgh.study.concurrent.synchronizer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock实现Semaphore
 * java.util.concurrent.Semaphore不是这么实现的啊！
 *
 * @author guohang.ding on 16-9-23
 */
@ThreadSafe
@SuppressWarnings("unused")
public class SemaphoreOnReentrantLock {

    private final ReentrantLock lock = new ReentrantLock();
    // 就算只有一组条件谓词，使用了Lock之后，也一定要使用Condition -> 三元关系
    private final Condition permitCondition = lock.newCondition();
    @GuardedBy("lock")
    private int permits;

    public SemaphoreOnReentrantLock(int permits) {
        lock.lock();
        try {
            this.permits = permits;
        } finally {
            lock.unlock();
        }
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permits <= 0) {
                permitCondition.await();
            }

            --permits;
        } finally {
            lock.unlock();
        }
    }

    public void release() {
        lock.lock();
        try {
            ++permits;
            permitCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
