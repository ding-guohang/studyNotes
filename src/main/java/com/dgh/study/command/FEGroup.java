package com.dgh.study.command;

/**
 * 前端组，模拟情景中的一个Receiver角色
 * @author guohang.ding on 16-11-15
 */
public class FEGroup implements Receiver {

    public void doSomething() {
        System.out.println("fe done");
    }
}
