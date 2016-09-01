package com.dgh.study.factory.abstractfactory;

/**
 * @author guohang.ding on 16-9-1
 */
public class ProductA2 extends AbstractProductA{

    public ProductA2() {
        common();
    }

    @Override
    public void doAType1() {
        System.out.println("pro a2 do a type 1");
    }

    @Override
    public void doAType2() {
        System.out.println("pro a2 do a type 2");
    }

    @Override
    public void doAType3() {
        System.out.println("pro a3 do a type 3");
    }
}
