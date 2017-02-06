package com.dgh.study.basis.constant;

/**
 * @author guohang.ding on 17-2-6
 */
public class ClassA {

    public static final String CONSTANT_A = "class.a";  // to class.a.new
    private static final String CONSTANT_B = "class.b";  // to class.b.new

    public static String getConstantB() {
        return CONSTANT_B;
    }
}
