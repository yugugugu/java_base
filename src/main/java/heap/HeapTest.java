package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapTest {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int len = 0;
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1val = 0;
                int o2val = 0;
                for(int i= 0 ;i<o1.length();i++){
                    o1val += o1.charAt(i);
                }
                for(int i= 0 ;i<o2.length();i++){
                    o2val += o2.charAt(i);
                }
                return  o2val-o1val;
            }
        });
        String[] strarr = new String[1000];
        heap.toArray(strarr);
        System.out.println(strarr[len]);
    }
}
