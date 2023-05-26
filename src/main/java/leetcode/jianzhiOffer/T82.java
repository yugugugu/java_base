package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T82 {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temList = new ArrayList<>();
        Arrays.sort(candidates);
        recall(temList,candidates,0,target);
        return resList;
    }

    private void recall(List<Integer> temList, int[] candidates, int deep, int target) {
        if (deep > candidates.length || target < 0) return;
        if (target == 0){
            resList.add(new ArrayList<>(temList));
            return;
        }


        for (int i = deep; i < candidates.length ; i++) {
            if (i>0 && candidates[i] == candidates[i-1]) continue;
            temList.add(candidates[i]);
            recall(temList,candidates,i+1,target-candidates[i]);
            temList.remove(temList.size()-1);
        }
    }


    public static void main(String[] args) {
        T82 t82 = new T82();
        t82.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
}
