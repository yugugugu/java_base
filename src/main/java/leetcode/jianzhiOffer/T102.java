package leetcode.jianzhiOffer;

public class T102 {
    public static void main(String[] args) {
        T102 t102 = new T102();
        t102.findTargetSumWays(new int[]{1,1,1,1,1},3);

    }
    public int findTargetSumWays(int[] nums, int target) {
        //先计算nums总和sum 起始就是挑选几个nums[i]*2 的值总和为target，转换为背包问题
        int sum = 0;
        for(int val : nums){
            sum += val;
        }

        //初始化
        int[] dp = new int[1000+target+sum+1];
        dp[1000] = 1;
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum+target; j > 0; j--) {
                   if (j-2*nums[i] >= 0)dp[j] += dp[j-2*nums[i]];
            }
        }
        return dp[sum+target];
    }
}
