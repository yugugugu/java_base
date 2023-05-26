package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;



public class T79所有数组 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temList = new ArrayList<>();
        dfs(nums,temList,0);
        return resList;
    }

    private void dfs(int[] nums, List<Integer> temList, int deep) {
        if(deep == nums.length){
            resList.add(new ArrayList<>(temList));
            return;
        }

        dfs(nums,temList,deep+1);
        temList.add(nums[deep]);
        dfs(nums,temList,deep+1);
        temList.remove(temList.size()-1);

    }
}
