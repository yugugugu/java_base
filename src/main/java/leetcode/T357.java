package leetcode;

public class T357 {
    public int countNumbersWithUniqueDigits(int n) {
        //总数是十个数字中挑选n个数，然后减去0开头的数就是结果
        int[] dp = new int[9];
        int all = 0;
        for (int j = 1; j <= n; j++) {
            int sum = 1;
            for (int i = 10; i > 10-j ; i--) {
                sum *= i;
            }
            int del = 1;
            for (int i = 9; i > 10-j ; i++) {
                del *=i;
            }
            dp[j] = sum -del;
            all += dp[j];
        }
        return all;
    }
}
