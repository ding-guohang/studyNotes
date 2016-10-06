package com.dgh.study.common;

import com.dgh.study.concurrent.condition.GrumpyBoundedBuffer;
import com.dgh.study.concurrent.exceptions.BufferEmptyException;
import com.dgh.study.factory.abstractfactory.AbstractFactory;
import com.dgh.study.factory.abstractfactory.AbstractProduct;
import com.dgh.study.factory.abstractfactory.CreatorLevel1;
import com.dgh.study.factory.abstractfactory.CreatorLevel2;

/**
 * Main
 * to test design pattern
 *
 * @author guohang.ding on 16-8-29
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//        useGrumpy();
        abstractFactory();
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

    private static void abstractFactory() {
        AbstractFactory level1 = new CreatorLevel1();
        AbstractProduct productA1 = level1.createProductA();
        AbstractProduct productB1 = level1.createProductB();

        AbstractFactory level2 = new CreatorLevel2();
        AbstractProduct productA2 = level2.createProductA();
        AbstractProduct productB2 = level2.createProductB();
    }

}
