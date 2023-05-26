package leetcode;

import java.sql.Timestamp;
import java.util.Arrays;

public class T743 {
    int N=100, M = 6000;
    public int[] head=new int[N];

    static class node{
        int to,next,w;
    }
    node[] edges =new node[M];

    int[] dist = new int[N];//记录最短距离
    {
        for(int i=0;i<N;i++){
            dist[i] = Integer.MIN_VALUE;
        }
    }
    boolean[] vis = new boolean[N];//记录顶点是不是有没有被保存
    int n, k;

    public static void main(String[] args) {
        T743 main = new T743();
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        this.n=n;
        this.k=k;
        //构建链式前向星存图
        //初始化为-1
        for(int i=0;i<n;i++){
            this.head[i] = -1;
        }
        //添加边
        for(int i=0;i<k;i++){
            edges[i].to = times[i][1];
            edges[i].w = times[i][2];
            edges[i].next = head[times[i][0]];
            head[times[i][0]] = i;
        }

        //使用迪杰斯特拉算法
        dijkstra();

        int ans =0;
        for(int dis:dist){
            ans =Math.max(ans,dis);
        }
        return ans;

    }
    public void dijkstra(){
        //迭代n次
        dist[k]=0;
        for(int p=1;p<=n;p++){
            //找到距离已经加入顶点集合距离最小且未背更新的点
            int t=-1;
            for(int i=1;i<n;i++){
                if(!vis[i] && (t==-1||dist[i]<dist[t])) t=i;
            }
            //标记最小距离的点更新
            vis[t] =true;
            //用最小距离的点更新其他点
            int count = head[t];
            while(t!=-1){
                dist[edges[t].to]=Math.min(dist[edges[t].to],dist[edges[t].to]+edges[t].w);
                t=edges[t].next;
            }
        }
    }
}
