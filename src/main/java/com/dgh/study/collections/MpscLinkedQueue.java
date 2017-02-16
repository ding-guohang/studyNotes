package com.dgh.study.collections;

/**
 * MpscLinkedQueue
 * 从QMQ里面看到了这个队列, 发现是复制并少量修改了netty的实现
 * 大致是无锁队列...适用于单消费者多生产者场景
 * <p>
 * <p>
 * 其实不支持remove就很容易理解了.
 * 无锁队列之所以可以无锁并支持多生产者模型, 就是用一种微弱的稳定性串联起了offer的并发操作
 * 一旦允许remove, remove头尾相关节点都有可能导致链表断裂
 * <p>
 * 里面有三种需要提一下的数据结构
 * Node, DefaultNode, Ref
 * 1.Node  声明了的next, volatile型, 还有AtomicReferenceFieldUpdater对next进行修改
 * 2.DefaultNode  Node的实现类, 声明了value
 * 3.Ref  分为TailRef和HeadRef, 分别声明了volatile的tailRef和headRef引用...还有各自的AtomicReferenceFieldUpdater
 * <p>
 * blog: http://blog.csdn.net/dingguohang/article/details/55252969
 *
 * @author guohang.ding on 17-2-13
 */
public class MpscLinkedQueue {
}
