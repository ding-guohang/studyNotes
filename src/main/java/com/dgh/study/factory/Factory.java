package com.dgh.study.factory;

/**
 * Description:
 * Define an interface for creating an object, but let subclasses decide which class
 * to instantiate. Factory method lets a class defer instantiation to subclasses.
 * <p/>
 * 定义：
 * 定义一个创建对象的接口，但由子类决定实例化哪一个类。
 * 工厂模式让类的实例化延迟到其子类
 * <p/>
 * 简单工厂模式（静态工厂模式）——只有一个工厂，静态方法创建产品
 * 替代单例——由工厂生成单例
 * 延迟初始化——维护一个Map，保存初始化之后的实例，避免重复创建和销毁的损耗
 * <p/>
 * 抽象工厂模式——产品族扩展不易，产品等级扩展容易
 *
 * @author guohang.ding on 16-8-29
 * @see com.dgh.study.factory.abstractfactory.AbstractProduct
 */
public interface Factory {
}
