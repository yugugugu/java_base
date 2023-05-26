package leetcode.jianzhiOffer;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T100 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int triLen = triangle.size();
        int[] dp = new int[triLen+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[1] = triangle.get(0).get(0);
        for (int i = 1; i < triLen; i++) {
            List<Integer> level = triangle.get(i);
            for (int j = level.size(); j > 0; j--) {
                dp[j] = Math.min(dp[j-1],dp[j]) + level.get(j-1);
            }
        }

        int minLastLevel  = Integer.MAX_VALUE;
        for (int i = 1; i <= triLen; i++) {
            minLastLevel = Math.min(dp[i],minLastLevel);
        }
        return minLastLevel;
    }
}
