package leetcode;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class T456 {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3,5,0,3,4}));
//        System.out.println(find132pattern(new int[]{1,0,1,-4,-3}));
    }
    public static   boolean find132pattern(int[] nums) {
        //练习一下单调栈
        Stack<Integer> stack = new Stack<>();
        int[] preBigNum = new int[nums.length];
        int[] preSmallNum = new int[nums.length];

        //填充递减单调栈
        for (int i = nums.length-1; i >= 0; i--) {
            if (stack.isEmpty()){
                stack.push(i);
            }else{
                while (!stack.isEmpty() && nums[stack.peek()]< nums[i]){
                    preBigNum[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            preBigNum[stack.pop()] = -1;
        }

        //填充递增单调栈
        for (int i = nums.length-1; i >= 0; i--) {
            if (stack.isEmpty()){
                stack.push(i);
            }else{
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                    preSmallNum[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            preSmallNum[stack.pop()] = -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (preBigNum[i] != -1 && preSmallNum[i] != -1 ){
                if(preBigNum[i] > preSmallNum[i]) return true;
                else {
                    int point = preSmallNum[i];
                    while (preSmallNum[point] != -1){
                        if(preBigNum[i] > preSmallNum[point]) return true;
                        point = preSmallNum[point];
                    }
                }
            }
        }

        return false;
    }
}