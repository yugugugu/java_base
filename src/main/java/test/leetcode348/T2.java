package test.leetcode348;

public class T2 {
    public int semiOrderedPermutation(int[] nums) {
        int begin = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) begin = i;
            if (nums[i] == nums.length) end = i;
        }

        int changeCount = 0;
        changeCount = begin + nums.length - end -1;

        if (begin > end) changeCount -= 1;
        return changeCount;
    }
}
