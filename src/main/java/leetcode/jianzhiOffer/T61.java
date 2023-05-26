package leetcode.jianzhiOffer;

import java.util.*;
import java.util.stream.Collectors;

public class T61 {
    public static void main(String[] args) {
        int[] num1 = {1,1,2};
        int[] num2 = {1,2,3};
        new T61().kSmallestPairs(num1,num2,2);
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<List<Integer>> heap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0)+ o2.get(1)- o1.get(0)-o1.get(1);
            }
        });

        List<Integer> addList = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                addList.add(nums1[i]);
                addList.add(nums2[j]);
                if(heap.size()<k){
                    heap.offer(new ArrayList<>(addList));
                }else{
                    int temp = heap.peek().get(0) + heap.peek().get(1);
                    if(nums1[i]+nums2[j] < temp){
                        heap.poll();
                        heap.offer(new ArrayList<>(addList));
                    }
                }
                addList.clear();
            }
        }

        List<List<Integer>> reslist = heap.stream().collect(Collectors.toList());
        return reslist;
    }
}
