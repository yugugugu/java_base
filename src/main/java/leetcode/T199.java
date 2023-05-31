package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        //层序遍历保存最后一个节点值
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();

        if (root == null) return resList;

        int levelCount = 1;
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelCount--;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (levelCount == 0){
                resList.add(node.val);
                levelCount = queue.size();
            }

        }
        return resList;
    }
}
