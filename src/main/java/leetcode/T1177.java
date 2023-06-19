package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T1177 {
    public static void main(String[] args) {
        T1177 t1177 = new T1177();
//        t1177.canMakePaliQueries("abcda",new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}});
        t1177.canMakePaliQueries("hunu",new int[][]{{0,3,1}});
    }
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> resList = new ArrayList<>();

        for(int[] query : queries){
            resList.add(canMakePali(s.substring(query[0],query[1]+1),query[2]));
        }
        return resList;
    }

    private Boolean canMakePali(String str, int k) {
        Set<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()){
            if (set.contains(ch)){
                set.remove(ch);
            }else{
                set.add(ch);
            }
        }

        return set.size()/2 <=k;
    }
}
