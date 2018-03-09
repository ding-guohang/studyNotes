package com.dgh.work.dp;

/**
 * 给定一个非负数数组，代表一个房子里的金钱
 * 不能抢劫相邻的房子
 * 给出最大抢劫金额
 *
 * @author guohang.ding on 2018/3/8.
 */
public class Rob {

    /**
     * f(n) = 包含索引为n的所有房子的最大金额
     * g(n) = 索引为n的房子的金额
     * <p>
     * f(n) = max{ f(n-2)+g(n), f(n-1) }
     */
    public int rob(int[] nums) {
        if (0 == nums.length) { //f(0)
            return 0;
        }

        if (1 == nums.length) { //f(1)
            return nums[0];
        }

        int a = 0;  // f(n-2), default is f(0)
        int b = nums[0]; // f(n-1), default is f(1)
        int now = 0;

        // begins with n = 2
        for (int i = 1; i < nums.length; i++) {
            now = max(a + nums[i], b);
            a = b;
            b = now;
        }
        return now;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
