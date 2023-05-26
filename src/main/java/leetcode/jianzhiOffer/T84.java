package leetcode.jianzhiOffer;

import java.util.*;

public class T84 {
    public List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        recall(0,nums);
        return resList;
    }

    private void recall(int deep, int[] nums) {
        if (deep == nums.length){
            List<Integer> temList = new ArrayList<>();
            for(int num:nums) temList.add(num);
            resList.add(temList);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = deep; i < nums.length ; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums,deep,i);
            recall(deep+1,nums);
            swap(nums,i,deep);
        }
    }

    private void swap(int[] nums, int deep, int i) {
        int tem = nums[deep];
        nums[deep] = nums[i];
        nums[i] = tem;
    }
}
