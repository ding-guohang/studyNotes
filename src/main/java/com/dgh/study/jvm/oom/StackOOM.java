package com.dgh.study.jvm.oom;

/**
 * 创建线程导致内存溢出
 * VM Args: -Xss2M
 *
 * @author guohang.ding on 2017/6/12.
 */
public class StackOOM {

    private void holdOn() {
        while (true) {

        }
    }

    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    holdOn();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        StackOOM oom = new StackOOM();
        oom.stackLeakByThread();
    }
}
