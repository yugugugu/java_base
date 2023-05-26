package leetcode.jianzhiOffer;

public class T107 {
    public static void main(String[] args) {
        T107 t107 = new T107();
        t107.updateMatrix(new int[][] {{0,0,1,0,1,1,1,0,1,1},{1,1,1,1,0,1,1,1,1,1},{1,1,1,1,1,0,0,0,1,1},{1,0,1,0,1,1,1,0,1,1},{0,0,1,1,1,0,1,1,1,1},{1,0,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,0,1,0,1},{0,1,0,0,0,1,0,0,1,1},{1,1,1,0,1,1,0,1,0,1},{1,0,1,1,1,0,1,1,1,0}});
    }
    public int[][] updateMatrix(int[][] mat) {
        //分两次动态规划，这里要注意两次dp更新的都是同一个数组，如果不是同一个数组会出现短视的问题，比如下面的思路二
        //一次从左上角到右下角，找当前位置距离左边和上边0的距离最大值，
        // 第二次从右下角到左上角，找距离右边和下边0的距离最大值，
        //两个矩阵取最小值
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : 10000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }

    //第二种方法，多源bfs，以每个为0的位置作为顶点，进行bfs,然后更新最小值

    //这是错误的思路
    public int[][] updateMatrixTwo(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp1 = new int[m+1][n+1];
        int[][] dp2 = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp1[i][0] = 1000;
            dp2[i][n] = 1000;
        }
        for (int i = 0; i < n + 1; i++) {
            dp1[0][i] = 1000;
            dp2[m][i] = 1000;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (mat[i-1][j-1] == 0) dp1[i][j] = 0;
                else dp1[i][j] = Math.min(dp1[i-1][j],dp1[i][j-1])+1;
            }
        }

        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n-1; j >= 0 ; j--) {
                if (mat[i][j] == 0) dp2[i][j] = 0;
                else dp2[i][j] = Math.min(dp2[i+1][j],dp2[i][j+1])+1;
            }
        }

        int[][] resArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                resArr[i][j] = Math.min(dp1[i+1][j+1],dp2[i][j]);
            }
        }
        return resArr;
    }
}
