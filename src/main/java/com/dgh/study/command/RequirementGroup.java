package com.dgh.study.command;

/**
 * 需求组，模拟情景中的一个Receiver角色
 *
 * @author guohang.ding on 16-11-15
 */
public class RequirementGroup implements Receiver{

    public void doSomething() {
        System.out.println("requirement done");
    }
}
