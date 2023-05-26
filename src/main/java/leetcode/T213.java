package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class T213 {
    public static void main(String[] args) {
        int[] nums ={1,1};
        System.out.println(get(nums));
    }
    public static  int get(int[] nums){
        //第一个和最后一个不能同时抢,那就计算一个1~n-1的，一个2~n的,取最大值返回
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] =nums[0];
        int max = 0;
        for(int i=2;i<dp.length;i++){
            for(int j=i-2;j>=0;j--){
                dp[i] = Math.max(dp[i],dp[j]+nums[i-1]);
            }
            max = Math.max(max,dp[i]);
        }
        Arrays.fill(dp,0);
        dp[1] =nums[1];
        for(int i=2;i<dp.length;i++){
            for(int j=i-2;j>=0;j--){
                dp[i] = Math.max(dp[i],dp[j]+nums[i]);
            }
            max = Math.max(max,dp[i]);
        }

        return  max;
    }
}
