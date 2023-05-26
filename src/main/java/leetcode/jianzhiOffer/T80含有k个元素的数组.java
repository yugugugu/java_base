package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class T80含有k个元素的数组 {
    List<List<Integer>> resList = new ArrayList<>();
    int k = 0;
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temList = new ArrayList<>();
        this.k = k;
        dfs(temList,1,n);
        return resList;
    }
    private void dfs(List<Integer> temList, int deep,int n) {
        if(deep == n+1){
            if(temList.size() == k)
                resList.add(new ArrayList<>(temList));
            return;
        }

        dfs(temList,deep+1,n);
        if (temList.size() >= k) return;
        temList.add(deep);
        dfs(temList,deep+1,n);
        temList.remove(temList.size()-1);

    }
}
