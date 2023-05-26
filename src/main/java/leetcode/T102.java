package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> temList = new ArrayList<>();
        if (root == null) return  res;
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            temList.add(node.val);
            count -- ;
            if (count == 0){
                count = queue.size();
                res.add(new ArrayList<>(temList));
                temList.clear();
            }
        }
        return res;

    }

}
