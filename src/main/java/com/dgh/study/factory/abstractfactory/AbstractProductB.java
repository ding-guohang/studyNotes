package com.dgh.study.factory.abstractfactory;

import com.dgh.study.factory.Product;

/**
 * Abstract product A
 * @author guohang.ding on 16-9-1
 */
public abstract class AbstractProductB implements Product{

    public void common() {
        System.out.println("implement common method by abstract product B");
    }

    /**
     * ProductA need to implement do A type1
     */
    public abstract void doAType1();

    /**
     * ProductA need to implement do A type2
     */
    public abstract void doAType2();

    /**
     * ProductA need to implement do A type3
     */
    public abstract void doAType3();
}
