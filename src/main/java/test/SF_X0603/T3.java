package test.SF_X0603;

import java.util.*;

public class T3 {
    public  static int notUsedMagicMax = Integer.MAX_VALUE;
    public static int target =0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        target = n-1;

        int[][] graph = new int[n][n];
        for (int i = 0; i < m ; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            int wight = in.nextInt();

            graph[begin-1][end-1] = wight;
            graph[end-1][begin-1] = wight;
        }

        //先计算使用魔法的情况
        int usedMagicMax = 0;
        int begintoNext = Integer.MAX_VALUE;
        for (int i = 1; i < n ; i++) {
            if (graph[0][i] != 0) begintoNext = Math.min(begintoNext,graph[0][i]);
        }
        int endToPre = Integer.MAX_VALUE;
        for (int i = 1; i < n ; i++) {
            if (graph[n-1][i] != 0) endToPre = Math.min(endToPre,graph[n-1][i]);
        }
        if (begintoNext == Integer.MAX_VALUE || endToPre == Integer.MAX_VALUE){
            usedMagicMax = Integer.MAX_VALUE;
        }else {
            usedMagicMax = begintoNext + endToPre + x;
        }


        //不使用魔法的情况
        boolean[] usedPath = new boolean[n];
        dfs(graph,usedPath,0,0);
        if (usedMagicMax == Integer.MAX_VALUE && notUsedMagicMax == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(Math.min(notUsedMagicMax,usedMagicMax));
        }
    }

    private static void dfs(int[][] graph, boolean[] usedPath, int node,int sum) {
        if (node == target){
            notUsedMagicMax = Math.min(notUsedMagicMax,sum);
            return;
        }

        for (int i = 0; i < graph.length; i++) {
            usedPath[node] = true;
            if (!usedPath[i] && graph[node][i] != 0){
                dfs(graph,usedPath,i,sum+graph[node][i]);
            }
        }
    }
}
