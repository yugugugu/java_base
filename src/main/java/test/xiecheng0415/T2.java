package test.xiecheng0415;

import java.math.BigDecimal;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            getNum(arr[i]);
        }
    }

    public static void getNum(long sum) {
        long a = sum/2;
        long b = sum - a;
        long outA = a;
        long outB = b;
        long mutil = getMutil(a,b);
        while (a > 0){
            a = a-1;
            b = b+1;
            if (a*b > mutil){
                outA = a;
                outB = b;
                mutil = getMutil(a,b);
            }
        }
        System.out.println(""+outA+" "+outB);
    }

    public static long getMutil(long a, long b) {
        long mutil = a*b;
        while (a!=0){
            long tem = b%a;
            b = a;
            a = tem;
        }
        return mutil/b;
    }
}
