package leetcode;

import sun.swing.icon.SortArrowIcon;

public class T31 {
    public static void main(String[] args) {
        T31 t31 = new T31();
        t31.nextPermutation(new int[]{4,2,0,2,3,2,0});
    }
    public void nextPermutation(int[] nums) {
        boolean isBreak =false;
        for (int i = nums.length-1; i >0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[i] > nums[j]){
                    int beRepalce = nums[j];
                    nums[j] = nums[i];
                    nums[i] = beRepalce;
                    sortArr(nums,j+1,nums.length);
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) break;
        }

        //本身是最大排列则需要翻转过来
        if (!isBreak){
            for (int i = 0; i < (nums.length-1)/2; i++) {
                int temval = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = temval;
            }
        }
    }

    private void sortArr(int[] nums, int begin, int end) {
        //传入数组begin到end部分按升序排
        for (int i = begin; i < end; i++) {
            int minPlace = i;
            for (int j = i; j < end ; j++) {
                if (nums[j] < nums[minPlace]){
                    minPlace = j;
                }
            }

            int temVal = nums[i];
            nums[i] = nums[minPlace];
            nums[minPlace] = temVal;
        }
    }
}
