package test.pdd0418;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int count = 0;
        for (int ya = 1; ya < y; ya++) {
            for (int xa = 0; xa <= x-2;xa++){
                for (int xd = xa+2; xd <=x ; xd= xd+2) {
                        for (int yc = 0; yc < ya; yc++) {
                            if (ya+(ya-yc)<=y ) count++;
                        }
                }
            }
        }
        System.out.println(count);
    }
}