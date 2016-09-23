/**
 * ReentrantLock 和 Semaphore 在功能上其实相当相似
 * @see java.util.concurrent.locks.ReentrantLock
 * @see java.util.concurrent.Semaphore
 * 现象上都是类似于对线程的阀门
 *
 * 当线程到达阀门时，他们都支持如下的操作:
 * 通过 lock/acquire
 * 阻塞 lock/acquire
 * 取消 tryLock/tryAcquire
 *
 * 他们也都支持可中断的、不可中断的、限时的等待
 * 公平、非公平的队列操作
 *
 * 仿佛ReentrantLock就是Semaphore实现的，或者反过来一样
 * @see com.dgh.study.concurrent.synchronizer.SemaphoreOnReentrantLock
 *
 * @author guohang.ding on 16-9-23
 */
package com.dgh.study.concurrent.synchronizer;