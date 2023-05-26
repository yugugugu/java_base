package leetcode.jianzhiOffer;

import java.util.*;

public class T115 {
    public static void main(String[] args) {
        main2();
    }
    public static boolean main2(){
        int[] nums = {1,2,3};
        int[][] sequences ={{1,2},{1,3}};
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i: nums){
            graph.put(i,new ArrayList<Integer>());
        }
        //遍历所有的边加进去，同时计算每个节点的入度
        int[] inDegrees =new int[nums.length+1];
        for(int[] seq:sequences){
            if(seq.length>1){
                for(int i=1;i<seq.length;i++){
                    graph.get(seq[i-1]).add(seq[i]);
                    inDegrees[seq[i]]++;
                }
            }
        }

        //寻找入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<nums.length+1;i++){
            // System.out.println(inDegrees[i]);
            if(inDegrees[i]==0){
                queue.add(i);
            }
        }

        //保存已经删除的节点
        Queue<Integer> delQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            //存在多个入度为0的节点，这直接返回false
            System.out.println(queue.size());
            if(queue.size()>1) return false;
            int node = queue.remove();
            System.out.println(node+1);
            delQueue.add(node);
            for(int next:graph.get(node)){
                inDegrees[next]--;
                if(inDegrees[next]==0) queue.add(next);
            }
        }

        return true;
    }
}
