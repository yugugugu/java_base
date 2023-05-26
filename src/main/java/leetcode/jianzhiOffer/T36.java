package leetcode.jianzhiOffer;

import java.util.Stack;

public class T36 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a;
        int b;
        for(String token : tokens){
            if (token.equals("+")){
                a =stack.pop();
                b =stack.pop();
                stack.push(a+b);
            }else if(token.equals("-")){
                a =stack.pop();
                b =stack.pop();
                stack.push(b-a);
            }else if(token.equals("*")){
                a =stack.pop();
                b =stack.pop();
                stack.push(a*b);
            }else if(token.equals("/")){
                a =stack.pop();
                b =stack.pop();
                stack.push(b/a);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();

    }
}
