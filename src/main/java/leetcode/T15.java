package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        //先排序，然后固定一个找另外两个
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 ; i++) {
            int sum = 0 - nums[i];
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int mid = i+1,next =  nums.length-1;
            while (mid < next){
                if (nums[mid] + nums[next] > sum){
                    next--;
                    while (mid < next && nums[next] == nums[next+1]){
                        next--;
                    }
                }else if(nums[mid] + nums[next] < sum){
                    mid++;
                    while (mid  < next && nums[mid] == nums[mid-1]){
                        mid++;
                    }
                }else {
                    List<Integer> temList = new ArrayList<>();
                    temList.add(nums[i]);
                    temList.add(nums[mid]);
                    temList.add(nums[next]);
                    resList.add(temList);
                    next--;
                    while (mid < next && nums[next] == nums[next+1]){
                        next--;
                    }
                }
            }

        }
        return resList;
    }
}
