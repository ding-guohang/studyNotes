package com.dgh.study.decorator;

import com.dgh.study.common.Component;

/**
 * @author guohang.ding on 16-8-29
 */
public class SimpleDecorator extends Decorator{

    public SimpleDecorator(Component component) {
        super(component);
    }

    public <T> T invoke() {
        before();
        T ret = component.invoke();
        after();
        return ret;
    }

    @Override
    protected void before() {
        System.out.println("simple before");
    }

    @Override
    protected void after() {
        System.out.println("simple after");
    }
}
