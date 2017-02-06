package com.dgh.study.basis.constant;

/**
 * 测试: (Main保持对常量的引用, 并不重新编译自己)
 * 1. 编译之后, 修改CONSTANT_A的值
 * 2. 直接执行是否会变化? 如果重新编译ClassA呢?
 * 3. 同样的条件对CONSTANT_B, 结果是一样的吗?
 * 4. 同样的条件对interface呢?
 *
 * 结论: interface 和 class.a效果一样
 * class.b完成了替换
 *
 * @author guohang.ding on 17-2-6
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("interface: " + InterfaceA.CONSTANT);
        System.out.println("class.a: " + ClassA.CONSTANT_A);
        System.out.println("class.b: " + ClassA.getConstantB());
    }
}
