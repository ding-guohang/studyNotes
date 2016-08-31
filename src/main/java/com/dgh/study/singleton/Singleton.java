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
 * 如果外部使用反射构造方法初始化
 * @see java.lang.NoSuchMethodException
 * 如果外部使用反射newInstance初始化
 * @see java.lang.IllegalAccessException
 *
 * 这种方式被成为饿汉式单例，还可以实现为
 * <code>
 *     public class Singleton {
 *         private static final Singleton singleton = null;
 *         private Singleton() {}
 *         public static synchronized Singleton getInstance() {
 *             if (singleton == null) {
 *                 singleton = new Singleton();
 *                 return singleton;
 *             }
 *         }
 *     }
 * </code>
 *
 * 要注意的是，不要实现Cloneable接口，因为克隆是不需要调用构造方法的
 *
 * Spring中，默认使用单例模式
 * 也可以通过指定Scope为Prototype，使每次请求创建一个新的实例，据说这样的话，Spring初始化后，就把这个类交给J2EE的容器不管了
 * Scope后来还新增了session、globalSession、request
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
