package leetcode;

public class T200 {
    //岛屿数量
    public int count = 0;
    public char[][] gridtem;
    public int numIslands(char[][] grid) {
        int length = grid.length;
        int width = grid[0].length;

        gridtem = grid;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,0,0);
                    count++;
                };
            }
        }
        return count;

    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if (grid[i][j] == '0') return;

        gridtem[i][j] = '0';

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        new T200().numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}});
    }
}
