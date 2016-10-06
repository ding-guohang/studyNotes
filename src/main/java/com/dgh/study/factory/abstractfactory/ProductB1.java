package com.dgh.study.factory.abstractfactory;

/**
 * @author guohang.ding on 16-10-6
 */
public class ProductB1 extends AbstractProduct {

    public ProductB1() {
        doSomething();
    }

    @Override
    public void doSomething() {
        System.out.println("do something by productB1");
    }
}
