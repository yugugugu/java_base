package leetcode;

public class T1130 {
    public static void main(String[] args) {
        T1130 t1130 = new T1130();
        t1130.mctFromLeafValues(new int[]{6,2,4});

    }
    public int[][] areaMaxVal;
    public int mctFromLeafValues(int[] arr) {
        areaMaxVal = new int[arr.length+1][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            areaMaxVal[i][i+1] = arr[i];
        }
        for (int i = 0; i <= arr.length; i++) {
            for (int j = i+2; j <= arr.length ; j++) {
                areaMaxVal[i][j] = areaMaxVal[i][j-1];
                if (arr[j-1]>areaMaxVal[i][j]) areaMaxVal[i][j] = arr[j-1];
            }
        }
        return maxLeafValues(arr,0,arr.length);
    }

    private int maxLeafValues(int[] arr, int begin, int end) {
        if (end - begin <= 1){
            return  0;
        }

        int maxSum = Integer.MAX_VALUE;
        for (int i = begin+1; i < end ; i++) {
            int leftTreeSum = maxLeafValues(arr,begin,i);
            int rightTreeSum = maxLeafValues(arr,i,end);
            maxSum = Math.min(maxSum,leftTreeSum + rightTreeSum
                    + areaMaxVal[begin][i]*areaMaxVal[i][end]);
        }
        return maxSum;
    }
}
