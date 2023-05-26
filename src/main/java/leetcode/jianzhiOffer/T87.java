package leetcode.jianzhiOffer;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T87 {
    public List<String> resList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        List<String> temList = new ArrayList<>();
        recall(s,temList,0);
        return resList;
    }

    private void recall(String s, List<String> temList, int i) {
        if (temList.size() == 4){
            if (i == s.length()){
                String str = "";
                for(String tem : temList){
                    str += tem+".";
                }
                resList.add(str.substring(0,str.length()-1));
            }
            return;
        }

        for (int j = i; j <i+3 && j < s.length() ; j++) {
            String temstr = s.substring(i,j+1);
            if (temstr.length()>1 && temstr.charAt(0) == '0') break;
            if (Integer.valueOf(temstr)>255) continue;
            temList.add(temstr);
            recall(s,temList,j+1);
            temList.remove(temList.size()-1);
        }
    }

    public static void main(String[] args) {
        T87 t87 = new T87();
        t87.restoreIpAddresses("25525511135");
    }

}
