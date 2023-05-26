package leetcode.jianzhiOffer;

public class T76 {
    public static void main(String[] args) {
        T76 test = new T76();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(test.findKthLargest(nums,4));
    }
    public int findKthLargest(int[] nums, int k) {
        //练习一下快排
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    public void  quickSort(int[] nums,int left,int right){
        if(left<right){
            int pviot = patition(nums,left,right);
            quickSort(nums,left,pviot-1);
            quickSort(nums,pviot+1,right);
        }
    }

    public int  patition(int[] nums,int left,int right){
         int val = nums[left];
         while (left < right){
             while(left < right&&nums[left] < val){
                 left++;
             }
             while(right > left && nums[right] > val){
                 right--;
             }
             if(nums[left] == nums[right] && left<right){
                 left++;
             }
             int tem = nums[left];
             nums[left] =nums[right];
             nums[right] = tem;
         }
         return left;
    }
}
