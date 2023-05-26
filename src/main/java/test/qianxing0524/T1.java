package test.qianxing0524;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T1 {
    public static void main(String[] args) {

    }
    public int pathCount = 0;
    //使用回溯
    public int DagPathNum (int[][] nodes) {
        // write code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            List<Integer> edges = new ArrayList<>();
            for (int j = 0; j < nodes[i].length; j++) {
                edges.add(nodes[i][j]);
            }
            graph.put(i,edges);
        }
        reCall(graph,0);
        return pathCount;
    }

    private void reCall( Map<Integer, List<Integer>> graph, int end) {
        if (end == 4){
            pathCount++;
            return;
        }
        for(int edge : graph.get(end)){
            reCall(graph,edge);
        }

    }
}
