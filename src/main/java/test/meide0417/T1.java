package test.meide0417;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr = scanner.nextLine();
        String[] split = arr.split(",");
        int[] list = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            list[i] =Integer.valueOf(split[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            for (int j = i+1; j < list.length; j++) {
                max = Math.max(max,list[i]*list[j]);
            }
        }
        System.out.println(max);

    }
}
