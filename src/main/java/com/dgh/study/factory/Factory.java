package com.dgh.study.factory;

import com.dgh.study.singleton.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author guohang.ding on 16-8-29
 */
public class Factory {

    public Factory() {
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Singleton.class.newInstance();
    }
}
