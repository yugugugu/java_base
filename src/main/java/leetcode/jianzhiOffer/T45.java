package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T45 {
    public int findBottomLeftValue(TreeNode root) {
        //用队列广度优先遍历
        int leveLen = 0,leftVal = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        leveLen = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            leveLen --;
            if (leveLen == 0){
                leveLen =queue.size();
                if(!queue.isEmpty())leftVal = queue.element().val;
            }

        }
        return leftVal;
    }
}
