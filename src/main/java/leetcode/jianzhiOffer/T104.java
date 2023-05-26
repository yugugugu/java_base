package leetcode.jianzhiOffer;

public class T104 {
    public static void main(String[] args) {
        T104 t104 = new T104();
        t104.combinationSum4(new int[]{1,2,3},4);
    }
    public int combinationSum4(int[] nums, int target) {
        //排列和组合是不同的，排列考虑顺序，组合不考虑是顺序，先物品后背包是组合，先背包后物品是排列
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i < target+1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i){dp[i] += dp[i - nums[j]];}
            }
        }
        return  dp[target];
    }



}
