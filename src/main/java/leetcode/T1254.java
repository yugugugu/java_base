package leetcode;

public class T1254 {
    public int closedIslandCount = 0;
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m < 3 || n < 3) return 0;

        for (int i = 1; i < m-1 ; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 0 && dfs(grid,i,j)) {
                    closedIslandCount++;
                }
            }
        }
        return closedIslandCount;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ){
            return false;
        }
        if (grid[i][j] == 1){
            return true;
        }

        grid[i][j] = 1;
        boolean res = true;
        res &= dfs(grid,i+1,j);
        res &= dfs(grid,i-1,j);
        res &= dfs(grid,i,j+1);
        res &= dfs(grid,i,j-1);
        return res;
    }
}
