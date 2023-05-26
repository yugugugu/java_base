package test.meide0417;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        //使用dp
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int[][] arr = parseToArray(input);
        int[][] dp = new int[arr.length][arr[0].length];

        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length;i++) {
            dp[i][0] = dp[i-1][0]+arr[i][0];
        }
        for (int i = 1; i < arr[0].length;i++) {
            dp[0][i] = dp[0][i-1]+arr[0][i];
        }
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+arr[i][j];
            }
        }
        System.out.println(dp[arr.length-1][arr[0].length-1]);
    }

    private static int[][] parseToArray(String input) {
        String[] lines = input.split("],");
        int[][] inputArray = new int[lines.length][];

        int i = 0;
        for (String line:lines){
            int j = 0;
            String[] elements =line.split(",");
            inputArray[i] = new int[elements.length];
            for (String element:elements){
                inputArray[i][j++] =
                        Integer.valueOf(element.replace("[","").replace("]",""));
            }
            i++;
        }
        return inputArray;
    }
}
