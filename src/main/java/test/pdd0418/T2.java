package test.pdd0418;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int x = 0;
        int y = 0;
        int addarea = 0;

        for (int i = 0; i < n-1 ; i++) {
            for (int j = i+1; j < n ; j++) {
                int highleft  = arr[i+1][0]-arr[i][0];
                if (i > 0) highleft += (arr[i][0] -arr[i-1][0]);

                int highright = arr[j][0] -arr[j-1][0];
                if (j+1 < n) highright += (arr[j+1][0] -arr[j][0]);
                int di = Math.abs(arr[j][1]-arr[i][1]);

                if ((arr[i][1] > arr[j][1] && highleft<highright) ||(arr[i][1] < arr[j][1] && highleft>highright)){
                    int area = Math.abs(highleft-highright)*di;
                    if (area>addarea){
                        x = arr[i][0];
                        y = arr[j][0];
                        addarea =area;
                    }
                }
            }
        }
        if (addarea != 0){
            System.out.println(""+x+" "+y);
        }else{
            System.out.println(-1);
        }

    }
}
