package leetcode.jianzhiOffer;

import java.util.Deque;
import java.util.Stack;

public class T38 {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        //构建从左往右的单调递减栈
        Stack<Integer> stack = new Stack<>();
        int[] highNext = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int tem = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < tem){
                highNext[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return highNext;
    }
}
