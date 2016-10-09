package com.dgh.study.factory.abstractfactory;

import com.dgh.study.factory.Factory;

/**
 * 抽象工厂类
 * 属于最上层建筑
 *
 * @author guohang.ding on 2016/10/6.
 */
public abstract class AbstractFactory implements Factory{

    public abstract AbstractProduct createProductA();

    public abstract AbstractProduct createProductB();
}
