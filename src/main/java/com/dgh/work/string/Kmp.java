package com.dgh.work.string;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * @author guohang.ding on 2018/3/2.
 */
public class Kmp {

    private static final String WHOLE = "ababcababababcab";
    private static final String AIM = "abababab";


    private static int[] getNext(String aim) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(aim));

        int[] next = new int[aim.length()];
        next[0] = -1;
        int k = -1;
        int i = 0;

        while (i < aim.length() - 1) {
            if (-1 == k || aim.charAt(i) == aim.charAt(k)) {
                next[++i] = ++k;
            } else {
                // 回溯到上一个可能匹配的最大节点
                k = next[k];
            }
        }

        return next;
    }

    public static void main(String[] args) {
        for (int i : getNext(AIM)) {
            System.out.println(i);
        }
    }
}
