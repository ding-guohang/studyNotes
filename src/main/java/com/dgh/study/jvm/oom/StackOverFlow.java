package com.dgh.study.jvm.oom;

/**
 * VM Args: -Xss128k
 * 栈深度128k
 *
 * @author guohang.ding on 2017/6/12.
 */
public class StackOverFlow {

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOverFlow flow = new StackOverFlow();
        try {
            flow.stackLeak();
        } catch (Throwable e) {
            System.out.println("error, stack length = " + flow.stackLength);
            throw e;
        }
    }
}
