package test.tenxunMusic0413;

import java.util.ArrayList;
import java.util.List;

public class T1 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fast(n));
    }
    public static int fast(int n){
        //i取值为0-n,思路是用一个用一个list集合（list1）保存到i的长度的好数组（用goodarr表示）goodarr[i-1]位置的值
        //因为新加进来的值只要和前一位不同就行，然后用一个list（list2）保存长度为i的每个好数组现在的陡峭值
        //遍历完成之后将list1的陡峭值加起来就可以

        //先初始化n为1的时候
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(0);
        list2.add(0);
        list1.add(0);
        list1.add(1);
        list1.add(2);

        //这里list不允许一边遍历的时候同时删除和加入，用一个暂存
        List<Integer> listtem1 = new ArrayList<>();
        List<Integer> listtem2 = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < list1.size(); j++) {
                int sumval =list2.get(j);
                int val =list1.get(j);
                if(val == 0){
                    listtem1.add(1);listtem1.add(2);
                    listtem2.add(sumval+Math.abs(1-val));listtem2.add(sumval+Math.abs(2-val));

                } else if (val == 1) {
                    listtem1.add(0);listtem1.add(2);
                    listtem2.add(sumval+Math.abs(0-val));listtem2.add(sumval+Math.abs(2-val));
                }else {
                    listtem1.add(0);listtem1.add(1);
                    listtem2.add(sumval+Math.abs(0-val));listtem2.add(sumval+Math.abs(1-val));
                }
            }
            List<Integer> listtem3 = list1;
            List<Integer> listtem4 = list2;
            list1 = listtem1;
            list2 = listtem2;
            listtem1 = listtem3;
            listtem2 = listtem4;
            listtem1.clear();
            listtem2.clear();

        }
        int sum = 0;
        for(int i :list2){
            sum += i;
        }
        return sum;

    }
}
