package test.xiecheng0415;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        long[] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+arr[i-1];
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += getCount(arr[i]);
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+2; j < arr.length; j+=2) {
                if(isHuiwen(arr,i,j)){
                    res += ((sum[j+1]-sum[i])-arr[(i+j)/2])/2;
                }
            }
        }
        res = res%1000000007L;
        System.out.println(res);
    }

    private static boolean isHuiwen(long[] arr, int i, int j) {
        while (i <= j){
            if (arr[i]!=arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static long getCount(long n){
        long res = 1;
        for (long i = 1; i <=n ; i++) {
            res *= i;
            if (res > 1000000007L) res = res%1000000007L;
        }
        return res;
    }
}
