package leetcode.jianzhiOffer;

import java.util.*;

public class T83 {
    public List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
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

        for (int i = deep; i < nums.length ; i++) {
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
