package leetcode.jianzhiOffer;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T86 {
    List<List<String>> resList = new ArrayList<>();
    public String[][] partition(String s) {
        List<String> temList = new ArrayList<>();
        recall(s,0,temList);

        String[][] resArr = new String[resList.size()][];
        for(int i = 0; i < resList.size(); i++){
            List<String> list = resList.get(i);
            resArr[i] = list.toArray(new String[list.size()]);
        }
        return resArr;
    }

    private void recall(String s, int i,List<String> temList) {
        if (i >= s.length()) {
            resList.add(new ArrayList<>(temList));
            return;
        };

        for(String str : isHui(s,i)){
            temList.add(str);
            recall(s,i+str.length(),temList);
            temList.remove(temList.size()-1);
        }
    }

    private List<String> isHui(String s, int i) {
        List<String> list = new ArrayList<>();
        for (int j = s.length()-1; j >=i ; j--) {
            boolean flag = true;
            int left = i;
            int right = j;
            while (left<right){
                if (s.charAt(left) != s.charAt(right)){
                    flag = false;
                    break;
                }
                left++;right--;
            }
            if (flag) list.add(s.substring(i,j+1));
        }
        return list;

    }

    public static void main(String[] args) {
        T86 t86 = new T86();
        t86.partition("google");
    }
}
