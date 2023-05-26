package leetcode.jianzhiOffer;

import java.util.*;

public class T108 {
    public static void main(String[] args) {
        T108 t108 = new T108();
        List<String> list = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        t108.ladderLength("hit","cog",list);
    }

    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        //先转换为graph。邻接矩阵表示，然后用dijkstra算法求最短路径
        //错误做法，不能用dijkstra算法，因为头尾可能不在字典中
        int len = wordList.size();
        int[][] graph = new int[len][len];
        int begin = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            String wordA = wordList.get(i);
            if (wordA.equals(beginWord))begin = i;
            if (wordA.equals(end))end = i;
            for (int j = i+1; j < len ; j++) {
                String wordB = wordList.get(j);
                int difCount = 0;
                int point = 0;
                while (point < wordA.length()){
                    if (wordA.charAt(point) != wordB.charAt(point))
                        difCount++;
                    point++;
                }
                if (difCount == 1) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        int[] minPath = dijkstra(graph,begin,end);
        return minPath[end];
    }

    private int[] dijkstra(int[][] graph, int begin, int end) {

        int[] minPath = new int[graph.length];
        boolean[] isUsed = new boolean[graph.length];
        Arrays.fill(minPath,-1);
        minPath[begin] = 0;
        isUsed[begin] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[begin][i] == 1) minPath[i] = graph[begin][i];
        }
        for (int i = 1; i < graph.length; i++) {
            int min = Integer.MAX_VALUE;
            int minPoint = 0;
            for (int j = 1; j < graph.length; j++) {
                if (!isUsed[j] && minPath[j]!=-1 && min >minPath[j]){
                    min = minPath[j];
                    minPoint = j;
                }
            }
            
            isUsed[minPoint] = true;
            for (int j = 1; j < graph.length; j++) {
                if (!isUsed[j]){
                    if (graph[minPoint][j] == 1 && (min+graph[minPoint][j]<minPath[j] || minPath[j] == -1 )){
                        minPath[j] = min+graph[minPoint][j];
                    }
                }
            }
        }
        return minPath;
    }
}
