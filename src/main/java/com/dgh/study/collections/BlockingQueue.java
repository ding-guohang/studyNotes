package com.dgh.study.collections;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author guohang.ding on 17-2-4
 */
public class BlockingQueue {

    private static java.util.concurrent.BlockingQueue<String> queue = new LinkedBlockingDeque<>();

    static {
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
    }

    /**
     * look at the LinkedBlockingQueue.code.
     * try to get as many elements as possible less than maxSize.
     * never block because the number of elements is not maxSize.
     *
     * @param maxSize elements' size u want.
     * @return get how many elements
     */
    private static int drainTo(int maxSize) {
        List<String> demo = Lists.newArrayList();
        int ret = queue.drainTo(demo, maxSize);
        System.out.println("ret = " + demo);
        System.out.println("queue = " + queue);
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("drain to " + drainTo(6));
    }
}
