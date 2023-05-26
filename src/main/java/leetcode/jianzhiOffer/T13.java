package leetcode.jianzhiOffer;

public class T13 {
    int[][] mat;
    public T13(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        mat = new int[n+1][m+1];
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < m + 1; j++) {
                mat[i][j] = mat[i-1][j]+mat[i][j-1] -mat[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return mat[row2+1][col2+1] + mat[row1][col1] - mat[row1][col2+1] - mat[row2+1][col1];
    }
}
