package leetcode;

import java.util.HashSet;

public class T532 {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7},13));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n+1];

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < n+1; i++) {
            arr[i] = arr[i-1] + nums[i-1];
        }

        for (int i = 2; i <= n; i++) {
            set.add(arr[i - 2] % k);
            if (set.contains(arr[i] % k)) return true;
        }

        return  false;

    }
}
