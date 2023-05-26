package leetcode;

import java.util.function.DoublePredicate;

public class T53最大子数组和 {
    public int maxSubArray(int[] nums) {
        //动态规划问题dp[i]表示以nums[i-1]结尾的最大子数组的最大和
        int[] dp = new int[nums.length+1];
        int maxSum = Integer.MIN_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= nums.length ; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            maxSum = Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }

}
