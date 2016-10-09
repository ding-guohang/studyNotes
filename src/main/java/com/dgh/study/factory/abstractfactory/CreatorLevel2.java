package com.dgh.study.factory.abstractfactory;

/**
 * 创建2级产品
 *
 * @author guohang.ding on 16-9-1
 */
public class CreatorLevel2 extends AbstractFactory{

    @Override
    public AbstractProduct createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ProductB2();
    }
}
