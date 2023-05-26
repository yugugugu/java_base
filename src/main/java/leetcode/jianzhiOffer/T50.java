package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class T50 {
    public int pathsum = 0;
    public int target;
    public int pathSum(TreeNode root, int targetSum) {
        List<Long> list = new ArrayList<>();
        list.add(0L);
        target =targetSum;
        dfs(root,list);
        return pathsum;
    }

    private void dfs(TreeNode root, List<Long> list) {
        if (root == null) return;

        long newsum = list.get(list.size()-1) + root.val;
        for(long presum : list){
            if (newsum - presum < target) break;
            if (newsum - presum == target) pathsum++;
        }
        list.add(newsum);
        dfs(root.left,list);
        dfs(root.right,list);
        list.remove(list.size()-1);
    }
}
