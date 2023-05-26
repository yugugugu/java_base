package leetcode;

public class T363 {
    public static void main(String[] args) {
        System.out.println(maxSumSubmatrix(new int[][]{{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}},8));
    }
    public static   int maxSumSubmatrix(int[][] matrix, int k) {
        //朴素二维前缀和，可以用o(n)的四次方出结果
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] -dp[i-1][j-1] +matrix[i-1][j-1];
            }
        }
        int res = Integer.MIN_VALUE;
        int tem = Integer.MIN_VALUE;
        for (int i = 0; i < m+1; i++) {
            for (int j = i+1; j < m+1; j++) {
                for (int l = 0; l < n+1; l++) {
                    for (int o = l+1; o < n+1; o++) {
                        tem = dp[j][o] + dp[i][l] - dp[i][o]-dp[j][l];
                        if (tem <= k){
                            res = Math.max(res,tem);
                        }
                    }
                }
            }
        }
        return  res;
    }
}
