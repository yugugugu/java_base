package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class T354 {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
    public static int maxEnvelopes(int[][] envelopes) {
        //先对长度进行排序，然后根据最长递增子序列的解法dp
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int n = envelopes.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i-1; j >=0 ; j--) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] =Math.max(dp[i],dp[j]+1 );
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
