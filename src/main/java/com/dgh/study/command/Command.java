package com.dgh.study.command;

/**
 * Command
 * 命令的抽象……以此传递请求方和执行方的交互
 * <p>
 * 实现类应是由客户产生、经常性的命令
 *
 * @author guohang.ding on 16-11-15
 */
public interface Command<T> {

    T execute();
}
