package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T44 {
    public List<Integer> largestValues(TreeNode root) {
        //用队列广度优先遍历
        int leveLen = 0,levelMax =  Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        leveLen = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            leveLen --;
            levelMax = Math.max(levelMax,node.val);
            if (leveLen == 0){
                list.add(levelMax);
                leveLen =queue.size();
                levelMax = Integer.MIN_VALUE;
            }
        }
        return list;
    }
}
