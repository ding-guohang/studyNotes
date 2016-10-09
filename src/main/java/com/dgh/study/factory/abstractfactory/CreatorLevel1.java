package com.dgh.study.factory.abstractfactory;

/**
 * 创建1级产品
 *
 * @author guohang.ding on 16-9-1
 */
public class CreatorLevel1 extends AbstractFactory{

    @Override
    public AbstractProduct createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ProductB1();
    }
}
