package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class T85 {
    List<String> resList = new ArrayList<>();
    int maxsize;
    public List<String> generateParenthesis(int n) {
        StringBuilder ches = new StringBuilder();
        maxsize = n;
        recall(ches,0,0);
        return resList;
    }

    private void recall(StringBuilder ches, int left, int right) {
        if (right>left) return;
        if (left == maxsize){
            String temStr = ches.toString();
            while (right<maxsize){
                temStr +=")";
                right++;
            }
            resList.add(temStr);
            return;
        }

        ches.append("(");
        recall(ches,left+1,right);
        ches.deleteCharAt(ches.length()-1);
        ches.append(")");
        recall(ches,left,right+1);
        ches.deleteCharAt(ches.length()-1);

    }

    public static void main(String[] args) {
        T85 t85 = new T85();
        t85.generateParenthesis(3);
    }

}
