package com.dgh.work.dp;

public class KingAndGold {

    /**
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
     * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     *
     * 最优子结构
     * 状态
     * 边界
     *
     * dp(5, 10) = max{ dp(4, 10), dp(4, 10-gold[4][1]) + gold[4][2] }
     * dp(i, j) = max{ dp(i-1, j), dp(i-1, j-gold[i][1])+gold[i][2] }
     * @param gold x是金矿的用工量，y是金矿的收益
     * @param num 人数
     */
    public static int[] kingAndGold(int[][] gold, int num) {

    }
}
