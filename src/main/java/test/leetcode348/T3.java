package test.leetcode348;

import java.util.HashMap;
import java.util.Map;

public class T3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
//        t3.matrixSumQueries(3,new int[][]{{0,0,1},{1,2,2},{0,2,3},{1,0,4}});
        t3.matrixSumQueries(2,new int[][]{{1,1,1}});
    }

    //失败，超出内存限制了
    public long matrixSumQueries1(int n, int[][] queries) {
        int[][] matrix = new int[n][n];

        for(int[] query : queries){
            if (query[0] == 0){
                for (int i = 0; i < n; i++) {
                    matrix[query[1]][i] = query[2];
                }
            }else {
                for (int i = 0; i < n; i++) {
                    matrix[i][query[1]] = query[2];
                }
            }
        }

        long allSsum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                allSsum += matrix[i][j];
            }
        }
        return allSsum;
    }

    //这又超出时间限制了，真的不会做了
    public long matrixSumQueries2(int n, int[][] queries) {
        Map<Integer ,Integer[]> rowMap = new HashMap<>();
        Map<Integer ,Integer[]> columnMap = new HashMap<>();

        long allSum = 0;
        for (int i = 0; i < queries.length ; i++) {
            int[] query = queries[i];
            if (query[0] == 0){
                if (rowMap.containsKey(query[1])){
                    allSum -= rowMap.get(query[1])[0]*(n-columnMap.size());
                }
                for(int key : columnMap.keySet()){
                    if (rowMap.containsKey(query[1]) && rowMap.get(query[1])[1] > columnMap.get(key)[1]){
                        allSum -= rowMap.get(query[1])[0];
                    }else{
                        allSum -= columnMap.get(key)[0];
                    }
                }
                rowMap.put(query[1],new Integer[]{query[2],i});
                allSum += rowMap.get(query[1])[0]*n;
            }else {
                if (columnMap.containsKey(query[1])){
                    allSum -= columnMap.get(query[1])[0]*(n-rowMap.size());
                }
                for(int key : rowMap.keySet()){
                    if (columnMap.containsKey(query[1]) && columnMap.get(query[1])[1] > rowMap.get(key)[1]){
                        allSum -= columnMap.get(query[1])[0];
                    }else{
                        allSum -= rowMap.get(key)[0];
                    }
                }
                columnMap.put(query[1],new Integer[]{query[2],i});
                allSum += columnMap.get(query[1])[0]*n;
            }
        }
        return allSum;
    }

    //傻逼了，只要把所有的put进两个map，最后在做计算不就能节约很多时间吗，笨比了
    //傻了，也没有过，和上面一样是时间复杂度n的平方
    //正确的做法是从后面往前面推
    public long matrixSumQueries(int n, int[][] queries) {
        Map<Integer ,Integer[]> rowMap = new HashMap<>();
        Map<Integer ,Integer[]> columnMap = new HashMap<>();


        for (int i = 0; i < queries.length ; i++) {
            int[] query = queries[i];
            if (query[0] == 0){
                if (rowMap.containsKey(query[1])){
                    rowMap.get(query[1])[0] = query[2];
                    rowMap.get(query[1])[1] = i;
                }else {
                    rowMap.put(query[1],new Integer[]{query[2],i});
                }
            }else {
                if (columnMap.containsKey(query[1])){
                    columnMap.get(query[1])[0] = query[2];
                    columnMap.get(query[1])[1] = i;
                }else {
                    columnMap.put(query[1],new Integer[]{query[2],i});
                }
            }
        }

        long allSum = 0;
        for (int i = 0; i < n ; i++) {
            if (!columnMap.containsKey(i)) continue;
            else {
                allSum += columnMap.get(i)[0]*n;
            }
        }

        for (int i = 0; i < n ; i++) {
            if (!rowMap.containsKey(i)) continue;
            else {
                allSum += rowMap.get(i)[0]*(n-columnMap.size());
                for(int key : columnMap.keySet()){
                    if (rowMap.get(i)[1] > columnMap.get(key)[1]){
                        allSum -= columnMap.get(key)[0];
                        allSum += rowMap.get(i)[0];
                    }
                }
            }
        }
        return allSum;
    }

}
