package com.dgh.study.template;

/**
 * 基本方法：
 *        ———— 由子类实现，并在模板方法中被调用
 * 模板方法：
 *        ———— 一个或多个，每个方法都是一个框架，实现对基本方法的调用，完成固定的逻辑
 *
 * 其实更加抽象地来看，可以理解为【封装不变的，扩展可变的】
 * 
 * @author guohang.ding on 2016/10/6.
 */
public abstract class AbstractTemplate {

    protected abstract void doSomething();

    protected abstract void doAnything();

    /**
     * 遵循固定的逻辑组成算法
     */
    public final void algorithm() {
        doAnything();
        doSomething();
    }
}
