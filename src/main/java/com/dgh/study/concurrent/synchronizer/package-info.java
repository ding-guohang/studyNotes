/**
 * 旨在引出AQS，并学习其实现原理，以便更清晰地了解和使用同步容器
 *
 *
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
 * 当锁保护信号量状态时、许可为空时将阻塞
 *
 * 事实上，他们都是基于AQS实现的，大部分同步器都可以通过AQS容易并高效地构造出来
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer 构建锁和同步器的框架
 * 还有比如CountDownLatch、ReentrantReadWriteLock、FutureTask?等
 *
 * 使用AQS实现的同步器，不会在多个时刻产生阻塞，只会有一个，从而降低切换上下文的开销，并提高吞吐
 *
 * 举个实现的例子：
 * @see com.dgh.study.concurrent.synchronizer.OneShotLatch
 * 为什么我们使用内部类来继承AQS，把一部分功能委托给AQS实现，而不直接拓展AQS呢？
 * > > 破坏简洁性（虽然AQS的公共方法都不能改变状态）
 * > > 调用者误用
 *
 * 大致了解一下doAcquire
 * 他使用了Node，Node是一种CLH的变种
 * CLH 是一种自旋锁、无饥饿、公平
 * 它的Node注释写得很清晰
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer.Node
 * status字段只表示这个Node是否应该被阻塞，而不控制该线程获得锁
 * specific-notification-style
 *
 *
 *      +------+  prev +-----------+       +-----+
 * head |      | <---- |  status   | <---- |     |  tail
 *      +------+       +-----------+       +-----+
 *
 * volatile int waitStatus:
 * 为了避免竞争，acquire方法中，应该首先把node状态置为SIGNAL（-1），表明they need a signal
 * 再去尝试原子性的acquire
 * 如果Node进入了CANCELED（1）状态，它永远不会再变为其他状态，相应的线程也永远不会再阻塞
 * CONDITION（-2）表明该Node在一个队列中，在它的状态被置为0之前，它不会在进入别的队列，这个状态不会做任何事情，只是Simplifies machanics
 * 0：None of above
 *
 * volatile Node prev
 * volatile Node next
 * volatile Thread thread
 *
 * doAcquireShared大致就是在tail后面拼接一个新的Node(currentThread, SHARED--/EXCLUSION)，如果前置节点是头节点，就再try一下
 * 因为head其实是一个空节点，并不代表一个在等待的线程
 * 如果成功了，就释放自己结束阻塞，同时检查下一个Node是不是Shared，是的话唤醒
 *
 * @author guohang.ding on 16-9-23
 */
package com.dgh.study.concurrent.synchronizer;