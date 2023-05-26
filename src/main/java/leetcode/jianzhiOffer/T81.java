package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class T81 {
    int target;
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temList = new ArrayList<>();
        this.target = target;
        recall(temList,candidates,0,0);
        return resList;
    }

    private void recall(List<Integer> temList, int[] candidates, int deep,int sum) {
        if (deep >= candidates.length || sum >target){
            return;
        }
        if (sum == target) {
            resList.add(new ArrayList<>(temList));
            return;
        }


        temList.add(candidates[deep]);
        recall(temList,candidates,deep,sum+candidates[deep]);
        recall(temList,candidates,deep+1,sum+candidates[deep]);
        temList.remove(temList.size()-1);
        recall(temList,candidates,deep+1,sum);
    }

    public static void main(String[] args) {
        T81 t81 = new T81();
        t81.combinationSum(new int[]{2,3,6,7},7);
    }
}
