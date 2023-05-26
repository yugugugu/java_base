package leetcode;

public class T522 {
    int mod = (int)1e9+7;
    int[][][] cache;
    public int checkRecord(int n) {
        cache = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(n,0,0);
    }

    private int dfs(int n, int a, int b) {
        if(a >= 2) return 0;
        if (b >= 3) return 0;
        if(n == 0) return 1;
        if (cache[n][a][b]!= -1) return cache[n][a][b];
        int sum = 0;
        sum = dfs(n-1,a+1,0)%mod;
        sum = (sum+dfs(n-1,a,b+1))%mod;
        sum = (sum+dfs(n-1,0,0))%mod;
        cache[n][a][b]= sum;
        return sum;
    }
}
