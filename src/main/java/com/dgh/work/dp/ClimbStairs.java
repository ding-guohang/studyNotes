package com.dgh.work.dp;

public class ClimbStairs {

    /**
     * dp[i] = dp[i-1] + dp[i-2]
     * dp[0] = 1
     * dp[1] = 1
     * 动态规划
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int a = 1;
        int b = 2;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = a + b;
            a = b;
            b = ret;
        }
        return ret;
    }


    // 备忘录算法
    public int climbStairs1(int n) {
        if (n < 2) {
            return 1;
        }

        int[] cache = new int[n + 1];
        return calculate(n, cache);
    }

    // 递归
    public int climbStairs0(int n) {
        if (n < 2) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    private int calculate(int n, int[] cache) {
        if (n < 2) {
            return 1;
        }

        if (0 != cache[n]) {
            return cache[n];
        }

        int ret = calculate(n - 1, cache) + calculate(n - 2, cache);
        cache[n] = ret;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs1(2));
    }
}
