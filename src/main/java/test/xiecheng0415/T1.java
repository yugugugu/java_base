package test.xiecheng0415;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.next();
        }
        char[][] arrChar = new char[n][m];
        for (int i = 0; i <n; i++) {
            arrChar[i] = strs[i].toCharArray();
        }
        int count = 0;
        for (int i = 0; i <= n-2 ; i++) {
            for (int j = 0; j <= m-2; j++) {
                if(hasYou(i,j,arrChar)) count++;
            }
        }
        System.out.println(count);
    }
    public static boolean hasYou(int i,int j,char[][] arr){
        boolean y =false;
        boolean o =false;
        boolean u =false;
        for (int k = i; k < i+2; k++) {
            for (int l = j; l < j+2; l++) {
                if (arr[k][l] == 'y') y=true;
                else if (arr[k][l] == 'o') o=true;
                else if (arr[k][l] == 'u') u=true;
            }
        }
        return y&&o&&u;
    }
}
