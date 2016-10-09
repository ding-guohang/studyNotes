package com.dgh.study.factory.abstractfactory;

import com.dgh.study.factory.Product;

/**
 * Abstract product
 * @author guohang.ding on 16-9-1
 */
public abstract class AbstractProduct implements Product{

    public void common() {
        System.out.println("implement common method by abstract product");
    }

    public abstract void doSomething();
}
