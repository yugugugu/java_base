package test.pdd0418;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        //博弈论
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
            max = Math.max(coins[i],max);
        }
        if (max < 3 ) max =3;
        int[][] pd = new int[max+1][2];
        pd[0][0] = 0;pd[0][1] = 0;
        pd[1][0] = 1;pd[1][1] = 0;
        pd[2][0] = 1;pd[2][1] = 1;
        pd[3][0] = 2;pd[3][1] = 1;
        for (int i = 4; i <= max ; i++) {
            if (i%2 == 1){
                pd[i][0] = pd[i-1][1]+1;
                pd[i][1] = pd[i-1][0];
            }else{
                if (pd[i-1][1]+1 > pd[i/2][1]+i/2){
                    pd[i][0] = pd[i-1][1]+1;
                    pd[i][1] = pd[i-1][0];
                }else{
                    pd[i][0] = pd[i/2][1]+i/2;
                    pd[i][1] = pd[i/2][0];
                }
            }
        }
        for (int coin:coins){
            System.out.println(""+pd[coin][0]+" "+pd[coin][1]);
        }

    }
}
