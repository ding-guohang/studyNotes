package com.dgh.study.decorator;

import com.dgh.study.common.Component;

/**
 * Abstract Decorator
 * @author guohang.ding on 16-8-29
 */
public abstract class Decorator implements Component{

    protected Component component;

    protected void before() {}

    protected void after() {}

    public Decorator(Component component) {
        this.component = component;
    }

    public <T> T invoke() {
        before();
        T ret = component.invoke();
        after();
        return ret;
    }
}
