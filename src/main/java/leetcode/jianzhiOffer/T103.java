package leetcode.jianzhiOffer;

import java.util.Arrays;

public class T103 {
    public static void main(String[] args) {
        T103 t103 = new T103();
        t103.coinChange(new int[]{1,2,5},11);
    }
    public int coinChange(int[] coins, int amount) {
        //完全背包问题
        int[] dp = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount+1; j++) {
                if (j - coins[i]>=0 && dp[j - coins[i]] != Integer.MAX_VALUE ) dp[j] = Math.min(dp[j - coins[i]]+1,dp[j]);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
