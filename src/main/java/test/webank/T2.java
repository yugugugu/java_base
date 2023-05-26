package test.webank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][2] = i;
        }

        for (int i = 0; i < n; i++) {
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            int sum = getSum(arr,i,m);
            res[arr[i][2]] = sum;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }

    private static int getSum(int[][] copyOf,int point, int m) {
        PriorityQueue<Integer> list = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int j = 0; j < point; j++) {
            list.add(copyOf[j][1]);
        }
        int sum = 0;
        for (int i = 0; i < m && !list.isEmpty(); i++) {
            sum += list.peek();
            list.remove();
        }
        return sum;
    }
}
