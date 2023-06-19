package test.leetcode350;

import java.util.ArrayList;
import java.util.List;

public class T3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.specialPerm(new int[]{2,3,6});
    }
    public  int count = 0;
    public int specialPerm1(int[] nums) {
        //这样普通的排列组合会超时
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> list2 = new ArrayList<>();
        dfs(isUsed,nums,list2);
        return count;
    }

    private void dfs(boolean[] isUsed,int[] nums, List<Integer> list2) {
        if (list2.size()==nums.length){
            //判断是不是特别的组合
            if(isSpecialSort(list2)) count++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            list2.add(nums[i]);
            isUsed[i] = true;
            dfs(isUsed,nums,list2);
            isUsed[i] = false;
            list2.remove(list2.size()-1);
        }
    }

    private boolean isSpecialSort(List<Integer> list2) {

        for (int i = 0; i < list2.size()-1; i++) {
            if (list2.get(i)%list2.get(i+1) != 0 && list2.get(i+1)%list2.get(i) != 0)
                return false;
        }

        return true;

    }

    public int specialPerm(int[] nums) {
        //状态压缩dp可以解决，和题目526很像
        int n = nums.length;
        int mask = 1<<n;
        int[][] dp = new int[n][mask];

        dp[0][0] = 1;
        for (int i = 1; i <=n ; i++) {
            for (int state = 0; state < mask; state++) {
                for (int j = 1; j <= n; j++) {
                    if ((state >> (j-1) & 1) == 0) continue;
                    //需要和上一个被选中的数满足相互取余有一个为0的关系
                    //这需要上一个选中数的状态，不知道这么做了

                }
            }
        }
        return 1;
    }


}
