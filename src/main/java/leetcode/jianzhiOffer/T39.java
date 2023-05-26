package leetcode.jianzhiOffer;

import java.util.Stack;

public class T39 {
    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
    public static int largestRectangleArea(int[] heights) {
        //用单调栈找左右边界，以当前长度为高，左右边界为宽，计算最大面积
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] left = new  int[heights.length];
        int[] right = new  int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            left[i] = i-1;
            right[i] = i+1;
        }

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea,(right[i] - left[i]-1)*heights[i]);
        }
        return maxArea;

    }
}
