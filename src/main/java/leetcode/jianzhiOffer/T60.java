package leetcode.jianzhiOffer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class T60 {
    private PriorityQueue<Map.Entry<Integer,Integer>> heap;
    private Map<Integer,Integer> map = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        heap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()- o1.getValue();
            }
        });
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(heap.size() < k){
                heap.offer(entry);
            }else{
                if (entry.getValue() > heap.peek().getValue()){
                    heap.poll();
                    heap.offer(entry);
                }
            }
        }
        int[] resarr = new int[k];
        for (int i = 0; i < heap.size(); i++) {
            resarr[i] = heap.poll().getKey();
        }
        return resarr;
    }
}
