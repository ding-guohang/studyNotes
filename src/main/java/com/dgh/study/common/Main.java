package com.dgh.study.common;

import com.dgh.study.concurrent.condition.GrumpyBoundedBuffer;
import com.dgh.study.concurrent.exceptions.BufferEmptyException;

/**
 * Main
 * to test design pattern
 *
 * @author guohang.ding on 16-8-29
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        useGrumpy();
    }

    private static void useGrumpy() throws InterruptedException {
        GrumpyBoundedBuffer<String> buffer = new GrumpyBoundedBuffer<>(1);
        while (true) {
            try {
                buffer.take();
                System.out.println("finish");
                return;
            } catch (BufferEmptyException e) {
                System.out.println("re do");
                Thread.sleep(1000);
            }
        }
    }

}
