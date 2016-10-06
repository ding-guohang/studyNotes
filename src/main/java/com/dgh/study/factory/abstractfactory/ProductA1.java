package com.dgh.study.factory.abstractfactory;

/**
 * @author guohang.ding on 16-9-1
 */
public class ProductA1 extends AbstractProduct {

    public ProductA1() {
        doSomething();
    }

    @Override
    public void doSomething() {
        System.out.println("do something by productA1");
    }
}
