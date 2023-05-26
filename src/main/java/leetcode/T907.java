package leetcode;

import java.util.Stack;

class T907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));
    }
    public static int sumSubarrayMins(int[] arr) {
        //两个单调栈，一个记录左边第一个更小的值，另外一个记录右边第一个更大的值
        //记录每个arr[i]为子数组最小值的次数，然后相乘累加即可
        int n =arr.length;
        int[] sum = new int[n+1];
        //计算1-n前缀乘积
        sum[0] = 1;
        for(int i = 1; i <= n; i++ ){
            sum[i] = i*sum[i-1];
        }
        
        int[] preSmall = new  int[n];
        int[] nextSmall = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                nextSmall[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            nextSmall[stack.pop()] = n;
        }

        for (int i = n-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                preSmall[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            preSmall[stack.pop()] = -1;
        }
        
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += arr[i]*sum[nextSmall[i]-preSmall[i]-1];
        }
        return count;

    }
}