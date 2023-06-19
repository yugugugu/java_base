package test.leetcode349;

import java.util.*;

public class T1 {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return  -1;

        Set<Integer> set = new HashSet<>();

        for(int val : nums){
            set.add(val);
            if (set.size() == 3) break;
        }
        if (set.size() == 3){
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            return list.get(1);
        }
        return -1;

    }
}
