package leetcode.jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class T41 {
    /** Initialize your data structure here. */

    int maxSize;
    int sum = 0;
    Queue<Integer> queue;
    public T41(int size) {
        maxSize = size;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() < maxSize){
            sum += val;
            queue.add(val);
        }else {
            sum += val;
            sum -= queue.remove();
            queue.add(val);
        }
        return  (double)sum/(double)queue.size();
    }
}
