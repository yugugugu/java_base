package test.leetcode350;

import java.util.Arrays;

public class T2 {
    public int findValueOfPartition(int[] nums) {
        int minval = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length ; i++) {
            minval = Math.min(minval, Math.abs(nums[i] - nums[i - 1]));

        }
        return minval;
    }
}
