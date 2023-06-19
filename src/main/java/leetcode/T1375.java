package leetcode;

public class T1375 {
    public static void main(String[] args) {
        T1375 t1375 = new T1375();
        t1375.numTimesAllBlue(new int[]
                {1,2,3,4,5,6,18,8,30,10,11,12,13,14,17,16,15,7,19,20,41,22,23,24,33,26,27,25,29,9,31,32,28,34,35,36,37,38,39,40,21,42});
    }
    public int numTimesAllBlue(int[] flips) {
        int ans = 0, mx = 0, n = flips.length;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, flips[i]);
            if (mx == i + 1) ans++;
        }
        return ans;
    }
}
