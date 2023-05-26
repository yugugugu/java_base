package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T1218 {
    public int longestSubsequence(int[] arr, int d) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            int prev =  arr[i] - d;
            dp[i][1] = 1;
            if(map.containsKey(prev))
                dp[i][1] =  Math.max(1,dp[map.get(prev)][1]+1);
            map.put(arr[i],i);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
