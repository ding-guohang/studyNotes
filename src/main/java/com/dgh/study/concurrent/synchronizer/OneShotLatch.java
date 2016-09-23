package com.dgh.study.concurrent.synchronizer;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 二元闭锁
 * 当关闭时，所有线程阻塞
 * 当开启时，所有阻塞线程释放
 *
 * 将一部分功能，委托给AQS，来更便捷地实现同步
 *
 * 使用AQS的状态0表示关闭， 1表示开启
 *
 * @author guohang.ding on 16-9-23
 */
@ThreadSafe
@SuppressWarnings("unused")
public class OneShotLatch {

    private final Sync sync = new Sync();

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    public void signal() {
        sync.releaseShared(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {

        /**
         * 如果状态是开启，tryAcquire将成功
         * 关闭，将返回失败，执行阻塞
         */
        protected int tryAcquireShared(int ignored) {
            return getState() == 1 ? 1 : -1;
        }

        /**
         * 设置状态为开启，让所有线程通过
         */
        protected boolean tryReleaseShared(int ignored) {
            setState(1);
            return true;
        }
    }
}
