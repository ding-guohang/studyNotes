package com.dgh.study.decorator;

/**
 * Common component for all design pattern
 * having invoke method
 * @author guohang.ding on 16-8-29
 */
public interface Component {

    public <T> T invoke();
}
