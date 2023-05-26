package test.xiecheng0415;

import java.util.*;

public class T3 {
    public static Long min;
    public static Long max;

    public static  int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        min = in.nextLong();
        max = in.nextLong();
        String str = in.next();
        char[] charArr = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (2*n-2); i++) {
            list.add(in.nextInt());
        }
        //用map保存图
        Map<Integer,List<Integer>> map  = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            map.put(i,new ArrayList<Integer>());
        }

        int point = 0;
        while (point < list.size()){
            int begin = list.get(point);
            int end = list.get(point+1);
            map.get(begin).add(end);
            map.get(end).add(begin);
            point += 2;
        }

        boolean[] isUse = new boolean[n+1];
        //遍历每个节点，从每个节点出发看可不可以组成在范围内的
        for (int i = 1; i <= n; i++) {
            dfs(i,map,0L,charArr,isUse);
        }
        System.out.println(count);

    }

    private static void dfs(int i, Map<Integer, List<Integer>> map,long sum,char[] charArr,boolean[] isUse) {
        sum = sum << 1 ;
        if(charArr[i-1] == '1') sum += 1;

        if(sum <= max && sum >= min) count++;
        isUse[i] = true;
        for(int end: map.get(i)){
            if (!isUse[end]) dfs(end,map,sum,charArr,isUse);
        }
        isUse[i] = false;
    }
}
