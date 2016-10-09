package com.dgh.study.factory;

/**
 * Normal Product Interface
 * @author guohang.ding on 16-9-1
 */
public interface Product {

    /**
     * common method for all products to implement or use
     */
    public void common();

    /**
     * do something decided by product type
     */
    public void doSomething();
}
