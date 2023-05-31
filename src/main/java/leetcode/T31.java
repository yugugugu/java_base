package leetcode;

public class T31 {
    public void nextPermutation(int[] nums) {
        boolean isBreak =false;
        for (int i = nums.length-1; i >0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[i] > nums[j]){
                    int beRepalce = nums[j];
                    nums[j] = nums[i];
                    //先找被替换数和替换数（i-j）之间有没有比被替换数大的，有的话就直接插入被替换数，然后这里到替换数之间的数往后推
                    boolean isBreakTwo = false;
                    for (int k = j+1; k < i ; k--) {
                        if (beRepalce < nums[k]){
                            for (int l = i; l > k ; l--) {
                                nums[i] = nums[i-1];
                            }
                            nums[k] = beRepalce;
                            isBreakTwo = true;
                            break;
                        }
                    }
                    if (isBreakTwo){
                        isBreak = true;
                        break;
                    }
                    //没有被替换数和替换数（i-j）之间有没有比被替换数大的，则被替换数直接放最后
                    for (int k = i; k < nums.length-1 ; k++) {
                        nums[k] =nums[k+1];
                    }
                    nums[nums.length-1] = beRepalce;
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
}
