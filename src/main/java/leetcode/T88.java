package leetcode;

public class T88 {
    public static void main(String[] args) {
        T88 t88 = new T88();
        t88.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Point = m-1;
        int num2Point = n-1;
        int allPoint = m+n-1;

        while(num2Point >= 0 && num1Point >= 0){
            int a;
            if (nums1[num1Point] > nums2[num2Point]){
                nums1[allPoint] = nums1[num1Point];
                allPoint--;
                num1Point--;
            }else{
                nums1[allPoint] = nums2[num2Point];
                allPoint--;
                num2Point--;
            }
        }

        for (int i = 0; i <= num2Point; i++) {
            nums1[i] =nums2[i];
        }
    }


}
