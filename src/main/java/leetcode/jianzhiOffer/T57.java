package leetcode.jianzhiOffer;

public class T57 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for (int i = 1; i < nums.length ; i++) {
            long right = nums[i];
            for (int j = i-1; j >= 0 && i-j <= k ; j--) {
                long left = nums[j];
                if (Math.abs(right-left) <=t )  return true;
            }
        }
        return false;
    }
}
