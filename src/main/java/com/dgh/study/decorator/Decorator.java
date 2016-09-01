package com.dgh.study.decorator;

/**
 * Abstract Decorator
 * implements Component 是为了装饰器可以装饰装饰器
 * 但是其实可以抽出来一个Invoker，让Component扮演
 *
 * Filter其实也是一种装饰器模型
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
