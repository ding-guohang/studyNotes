/**
 * 旨在通过一步一步构建自定义的同步工具
 * <p>
 * 1、展示状态依赖管理
 * 2、展示一些有趣的同步类
 *
 * 构建一个有界缓存
 * First：BasedBoundedBuffer —— 同步的doPut， doGet， isFull， isEmpty
 * @see com.dgh.study.concurrent.condition.BaseBoundedBuffer
 * Second：GrumpyBoundedBuffer —— 最暴躁的方式 不满足条件直接抛出异常，由调用者管理依赖状态
 * @see com.dgh.study.concurrent.condition.GrumpyBoundedBuffer
 * Third：SleepyBoundedBuffer —— 最简陋的阻塞 自旋尝试，如果刚睡眠，条件满足，就浪费了一个完整的睡眠时间 => 条件通知
 * @see com.dgh.study.concurrent.condition.SleepyBoundedBuffer
 *
 * 条件通知
 *
 * 这时候使用了一个条件队列来实现
 * 条件队列的三元关系：条件谓词、加锁、wait方法
 *
 * 每当在等待一个条件时，一定要在等待的条件为真时通过某种方式发出通知
 *
 * Four：BoundedBuffer —— 使用条件队列实现的有界缓存 条件等待，等待唤醒
 * @see com.dgh.study.concurrent.condition.BoundedBuffer
 *
 *
 * 这样全量唤醒的方式太蠢了，太耗费资源了，满足什么条件的情况下，我们可以单个唤醒？
 * > > 所有等待线程的类型都相同
 * > > 单进单出
 *
 * 显然，当多个状态变量组合成一个巨大的条件谓词时，几乎无法达到第一个条件
 *
 * Condition N -> 1 Lock
 * 多个条件谓词，多个等待唤醒体系
 * @see java.util.concurrent.locks.Condition
 * @see com.dgh.study.concurrent.condition.ConditionBoundedBuffer
 *
 * @author guohang.ding on 16-9-22
 */
package com.dgh.study.concurrent.condition;