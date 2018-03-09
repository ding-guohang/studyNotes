package com.dgh.work.dp;

/**
 * 一个数组，有正有负，求最大连续元素相加的最大值
 *
 * @author guohang.ding on 2018/3/9.
 */
public class MaxContinuous {

    /**
     * 随时都有两个最大值，历史最大值和当前子串的最大值
     * 当前子串在构建过程中，一直会用当前最大值与历史最大值比较，可以理解为一路走来的最大值都在掌握中
     * 如果子串加上当前值为负数了，那就一定停止
     */
    public static int maxContinuous(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }

        int max = 0;
        int recent = 0;

        for (int i = 1; i < nums.length; i++) {
            recent += nums[i];
            if (recent < 0) {
                recent = 0;
                continue;
            }
            if (recent > max) {
                max = recent;
            }
        }
        return recent;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, 10, -4, 7, -1, -1, -1, -1, 20, 2, -5};
        System.out.println(maxContinuous(nums));
    }
}
