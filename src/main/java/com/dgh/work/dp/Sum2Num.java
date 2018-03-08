package com.dgh.work.dp;

import java.util.HashMap;
import java.util.Map;

public class Sum2Num {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int aim = target - nums[i];
            if (cache.containsKey(aim)) {
                return new int[] {i, cache.get(aim)};
            }

            cache.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSumGarbage(int[] nums, int target) {
        for (int i = 0; i < nums.length -1; i ++) {
            for (int j = i+1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 4};
        int target = 6;
        int[] ret = new Sum2Num().twoSumGarbage(nums, target);
        System.out.println("end");
    }
}
