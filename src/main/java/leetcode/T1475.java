package leetcode;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class T1475 {
    public static void main(String[] args) {
        finalPrices(new int[]{10,1,1,6});
    }
    public static int[] finalPrices(int[] prices) {
        int[] arr = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                arr[stack.peek()] = prices[stack.peek()]-prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            arr[stack.peek()] = prices[stack.peek()];
            stack.pop();
        }
        return arr;
    }
}
