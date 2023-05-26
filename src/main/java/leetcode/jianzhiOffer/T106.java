package leetcode.jianzhiOffer;

import java.util.*;

class T16 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        //分成两份，1表示加入第一份，2表示加入第二份
        int[] arr = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i] !=0) continue;
            queue.add(i);
            int count = 0;
            boolean isfirst = false;
            while (!queue.isEmpty()){
                if (count == 0) {
                    count = queue.size();
                    isfirst = !isfirst;
                }
                count--;
                int node = queue.remove();
                if (isfirst) arr[node] = 1;
                else arr[node] = 2;
                for (int j :graph[node]) {
                    if ((isfirst && arr[j] == 1) || (!isfirst && arr[j] == 2)) {
                        return false;
                    }
                    if (arr[j] == 0) queue.add(j);
                }
            }
        }
        return true;

    }
}