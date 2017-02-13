package com.dgh.study.collections;

/**
 * MpscLinkedQueue
 * 从QMQ里面看到了这个队列, 发现netty有一个类似的实现
 * 大致是无锁队列...适用于单消费者多生产者场景
 * 依赖CAS完成入队操作
 *
 * @author guohang.ding on 17-2-13
 */
public class MpscLinkedQueue {
}
