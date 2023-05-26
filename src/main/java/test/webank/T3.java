package test.webank;

import java.util.*;

public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        LinkedList<Integer[]> queue = new LinkedList<>();
        int tem1= scanner.nextInt();
        int tem2= scanner.nextInt();
        queue.add(new Integer[]{tem1,tem2});
        Map<Integer,Integer> map = new HashMap<>();
        map.put(tem1,tem2);
        for (int i = 1; i < n; i++) {
            Integer[] tem = queue.getLast();
            int c = scanner.nextInt();
            int count = scanner.nextInt();

            if (map.containsKey(c)){
                map.put(c,map.get(c)+count);
            }else {
                map.put(c,count);
            }

            if (c == tem[0]){
                tem[1] += count;
            }else {
                queue.add(new Integer[]{c,count});
            }
        }

        for(int k: map.keySet()){
            int val = map.get(k);
            val += (val-1/k) *k;
            map.put(k,val);
        }
        while (!queue.isEmpty()){
            Integer[] arr =  queue.poll();
            int sum = arr[1];
            if (sum % m == 0){
                map.put(arr[0],map.get(arr[0])-m);
            }
        }

        PriorityQueue<Map.Entry> sort = new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (int)o1.getKey() - (int)o2.getKey();
            }
        });
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            sort.add(entry);
        }
        System.out.println(sort.size());
        for(Map.Entry<Integer,Integer> entry: sort){
            System.out.println(""+entry.getKey()+" "+entry.getValue());
        }

    }
}
