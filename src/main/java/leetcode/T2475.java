package leetcode;

import java.util.HashSet;
import java.util.Set;

public class T2475 {
    public int unequalTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        if (set.size() < 3) return 0;

        int count = 1;
        count *= set.size();
        count *= set.size()-1;
        count *= set.size()-2;
        count = count/6;
        return  count;
    }
}
