package com.dgh.study.factory.abstractfactory;

import com.dgh.study.factory.Factory;

/**
 * @author guohang.ding on 16-9-1
 */
public abstract class AbstractFactoryA implements Factory{

    public abstract AbstractProductA createProductA1();

    public abstract AbstractProductA createProductA2();
}
