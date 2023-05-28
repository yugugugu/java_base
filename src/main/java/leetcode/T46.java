package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T46 {
    //全排列
    List<List<Integer>> allSort = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> resList = new ArrayList<>();
        dfs(nums,new boolean[nums.length],resList);
        return  allSort;
    }

    private void dfs(int[] nums, boolean[] isUsed, List<Integer> resList) {
        if (resList.size() == nums.length){
            allSort.add(new ArrayList<>(resList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            resList.add(nums[i]);
            isUsed[i] = true;
            dfs(nums,isUsed,resList);
            isUsed[i] = false;
            resList.remove(resList.size()-1);
        }
    }
}
