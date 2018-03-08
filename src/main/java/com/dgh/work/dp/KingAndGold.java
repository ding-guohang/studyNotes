package com.dgh.work.dp;

import java.util.Arrays;

public class KingAndGold {

    private static final int[][] GOLD = new int[5][2];
    private static final int NUM = 10;

    static {
        GOLD[0][0] = 3;
        GOLD[0][1] = 200;
        GOLD[1][0] = 4;
        GOLD[1][1] = 300;
        GOLD[2][0] = 3;
        GOLD[2][1] = 350;
        GOLD[3][0] = 5;
        GOLD[3][1] = 400;
        GOLD[4][0] = 5;
        GOLD[4][1] = 500;
    }

    /**
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
     * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     * <p>
     * 最优子结构: 第五个金矿不挖，最优子结构就是dp{4, 10}，要挖就是dp{4, 10 - gold[4][0]} + gold[4][1]
     * 边界: 如果人数少于gold[0][0]，那结果就是0
     * 状态:
     * <p>
     * dp(i, j) 表示投入 j 个人力，挖 i 个金矿的最大收益
     * dp(5, 10) = max{ dp(4, 10), dp(4, 10-gold[4][1]) + gold[4][2] }
     * dp(i, j) = max{ dp(i-1, j), dp(i-1, j-gold[i][1]) + gold[i][2] }
     * <p>
     * dp(i, j) 与 dp(i-1) 这一行有关，所以保留这一行的最大收益就足够了
     * 如果这道题目是要问挖哪些金矿，那就用对象来保留返回值，里面存储着金矿组合和最大收益
     *
     * @param gold 第一列是金矿的用工量，第二列是金矿的收益
     * @param num  人数
     */
    public static int kingAndGold(int[][] gold, int num) {
        if (gold.length == 1) {
            if (num < gold[0][0]) {
                return 0;
            } else {
                return GOLD[0][1];
            }
        }

        Result[] last = new Result[]{
                new Result(new int[0], 0), new Result(new int[0], 0), new Result(new int[0], 0),
                new Result(new int[]{0}, 200), new Result(new int[]{0}, 200), new Result(new int[]{0}, 200),
                new Result(new int[]{0}, 200), new Result(new int[]{0}, 200), new Result(new int[]{0}, 200),
                new Result(new int[]{0}, 200), new Result(new int[]{0}, 200), new Result(new int[]{0}, 200)};
        // 保留dp(i-1)这一行, 索引是工人数量
        for (int i = 2; i < GOLD.length; i++) {
            //金矿
            Result[] temp = new Result[num + 1];
            for (int j = 0; j <= num; j++) {
                if (j < GOLD[i][0]) {
                    temp[j] = last[j];
                    continue;
                }

                // 不考虑收益可能恰好相等的情况
                // 如果这里不要result这么麻烦的话，就可以写得好看点儿了

                // i矿不挖更好
                if (last[j].getRet() > last[j - GOLD[i][0]].getRet() + GOLD[i][1]) {
                    temp[j] = last[j];
                } else {
                    // 要挖i矿
                    int[] copyOf = Arrays.copyOf(last[j - GOLD[i][0]].getGolds(),
                            last[j - GOLD[i][0]].getGolds().length + 1);
                    copyOf[last[j - GOLD[i][0]].getGolds().length] = i;
                    temp[j] = new Result(copyOf, last[j - GOLD[i][0]].getRet() + GOLD[i][1]);
                }
            }
            last = temp;
        }


        return last[num].getRet();
    }

    public static void main(String[] args) {
        System.out.println(GOLD.length); // 金矿数量
        System.out.println(GOLD[0].length);
        System.out.println(".....");
        System.out.println(kingAndGold(GOLD, NUM));
    }

    private static class Result {
        private int[] golds;
        private int ret;

        public Result(int[] golds, int ret) {
            this.golds = golds;
            this.ret = ret;
        }

        public int[] getGolds() {
            return golds;
        }

        public void setGolds(int[] golds) {
            this.golds = golds;
        }

        public int getRet() {
            return ret;
        }

        public void setRet(int ret) {
            this.ret = ret;
        }
    }
}
