package leetcode;


import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
import java.util.List;

;

public class T437 {
    public int target;
    public int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        //保存前缀和
        List<Integer> list = new ArrayList<>();
        list.add(0);
        target =targetSum;
        dfs(root,list);
        return count;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;

        int sum = list.get(list.size()-1)+root.val;
        for (int val:list) {
            if(sum - val == target) count++;
        }
        list.add(sum);
        dfs(root.left,list);
        dfs(root.right,list);

        list.remove(list.size()-1);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}