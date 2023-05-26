package leetcode.jianzhiOffer;

public class T90 {
    public int rob(int[] nums) {
        //两行dp一个是偷最后一个不偷第一个的情况，第二个是不偷最后一个偷第一个的情况
        int[] dp1 = new int[nums.length+1];
        if (nums.length==1) return nums[0];
        dp1[0] = 0;
        dp1[1] = 0;
        dp1[2] = nums[1];

        int[] dp2 = new int[nums.length+1];
        dp2[0] = 0;
        dp2[1] = nums[0];
        dp2[2] = nums[1];
        for (int i = 3; i <= nums.length ; i++) {
            dp1[i] = Math.max(dp1[i-2],dp1[i-3])+nums[i-1];
            dp2[i] = Math.max(dp2[i-2],dp2[i-3])+nums[i-1];
        }
        return Math.max(Math.max(dp1[nums.length],dp1[nums.length-1]),Math.max(dp2[nums.length-1],dp2[nums.length-2]));
    }
}
