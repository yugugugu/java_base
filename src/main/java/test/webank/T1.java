package test.webank;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arrA = new long[n];
        long[] arrB = new long[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = scanner.nextLong();
        }
        long La = scanner.nextLong();
        long Ra = scanner.nextLong();
        long Lb = scanner.nextLong();
        long Rb = scanner.nextLong();

        long[] sumA = new long[n+1];
        long[] sumB = new long[n+1];
        for (int i = 1; i <= n ; i++) {
            sumA[i] = sumA[i-1] + arrA[i-1];
        }
        for (int i = 1; i <= n ; i++) {
            sumB[i] = sumB[i-1] + arrB[i-1];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n+1 ; j++) {
                long diffA = sumA[j]-sumA[i];
                long diffB = sumB[j]-sumB[i];
                if (diffA <= Ra && diffA >= La && diffB <= Rb && diffB >= Lb){
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
