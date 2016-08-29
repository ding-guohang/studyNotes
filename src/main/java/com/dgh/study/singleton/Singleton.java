package com.dgh.study.singleton;

/**
 * Normal Singleton
 * be care for JVM.GC
 *
 * 单例可以在系统设置全局的访问点，优化和共享资源的访问
 * 减少不必要的开销
 *
 * 《设计模式之禅》——使用场景
 * 1、需要唯一的序列号
 * 2、全局的访问点
 * 3、创建对象消耗资源过多（比如IO、DB）
 *
 * 如果外界使用反射newInstance初始化，会出现Compilation failed: internal java compiler error
 *
 * @author guohang.ding on 16-8-29
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }
}
