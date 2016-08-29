package com.dgh.study.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author guohang.ding on 16-8-29
 */
public class Factory {

    public Factory() {
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("..");
        /*Constructor method2 = Factory.class.getConstructor();
        method2.newInstance();*/
    }
}
