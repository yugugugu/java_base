package leetcode;

public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sumLen = nums1.length + nums2.length;

        int mid = (sumLen-1)/2;
        int firstPoint = 0;
        int secondPoint = 0;

        while(firstPoint+secondPoint < mid){
            if (firstPoint == nums1.length){
                secondPoint++;
            }else if (secondPoint == nums2.length){
                firstPoint++;
            }else{
                if (nums1[firstPoint] > nums2[secondPoint]){
                    secondPoint++;
                }else {
                    firstPoint++;
                }
            }
        }

        if (firstPoint == nums1.length){
            mid = nums2[secondPoint];
            secondPoint++;
        }else if (secondPoint == nums2.length){
            mid = nums1[firstPoint];
            firstPoint++;
        }else{
            if (nums1[firstPoint] > nums2[secondPoint]){
                mid = nums2[secondPoint];
                secondPoint++;
            }else {
                mid = nums1[firstPoint];
                firstPoint++;
            }
        }

        if (sumLen%2 == 1) return mid;

        int midNext;
        if (firstPoint == nums1.length){
            midNext = nums2[secondPoint];
            secondPoint++;
        }else if (secondPoint == nums2.length){
            midNext = nums1[firstPoint];
            firstPoint++;
        }else{
            if (nums1[firstPoint] > nums2[secondPoint]){
                midNext = nums2[secondPoint];
                secondPoint++;
            }else {
                midNext = nums1[firstPoint];
                firstPoint++;
            }
        }

        return (mid+midNext)/2;
    }
}
