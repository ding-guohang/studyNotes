package com.dgh.study.command;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Invoker 请求方
 *
 * @author guohang.ding on 16-11-15
 */
public class Invoker {

    private BlockingQueue<Command> queue = new ArrayBlockingQueue<Command>(1 << 4);

    public void setCommand(Command command) {
        queue.add(command);
    }

    public void action() {
        queue.poll().execute(); //npe
    }
}
