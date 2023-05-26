package test.tenxunMusic0413;

public class T3 {
    public static void main(String[] args) {
        //这道题目直接排序1,2...n,2...n,3...n,n-1,n,n
        //也就是按这样排序的情况，最后就只会出现末尾的两个相同n相邻
        //这样我只要把最后一个n提到最前面来就不会出现相邻元素相同的情况了
        int n = 10;
        int len = n*(n+1)/2;
        int[] arr = new int[len];
        arr[0] = n;
        //保存数组位置
        int point = 1;
        for (int i = 1; i <= n; i++) {
           for (int j= i; j <=n && point<len;j++){
               arr[point] = j;
               point++;
           }
        }
        //自己记得返回数组
    }
}
