package com.dgh.work.dp;

/**
 * 题目
 * 给定一个整数  求所有相加等于它的组合的数量
 *
 * @author guohang.ding on 2018/3/7.
 */
public class DpSum {

    public static void main(String[] args) {
        int[][] dp;

        dp = new int[1000][1000];

        int n = 5;
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++) {
                dp[i][j] = 0;
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - j][k];
                }
            }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dp[n][i];
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++) {
                System.out.println("dp[" + i + "][" + j + "]=" + dp[i][j]);
            }
        System.out.println("n = " + n + ", sum = " + sum);
    }
}
