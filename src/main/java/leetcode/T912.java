package leetcode;

public class T912 {
    public int[] sortArray(int[] nums) {
        //手撕一下快速排序
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right){
            int point = partition(nums,left,right);
            quickSort(nums,left,point-1);
            quickSort(nums,point+1,right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int var = nums[left];
        while (left < right){
            while (left < right && nums[left] < var){
                left++;
            }
            while (left < right && nums[right] > var){
                right--;
            }
            if (left < right && nums[left] == nums[right]){
                left++;
            }
            int tem = nums[left];
            nums[left] = nums[right];
            nums[right] = tem;
        }
        return left;
    }
}
