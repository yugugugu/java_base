package leetcode.jianzhiOffer;


import java.util.LinkedList;
import java.util.Queue;

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
class T43 {
    Queue<TreeNode> queue;
    public TreeNode root;

    public T43(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        while(queue.peek().left != null && queue.peek().right != null){
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode temNode = new TreeNode(v);
        TreeNode node = queue.element();
        if (node.left == null){
            node.left = temNode;
        }else{
            node.right = temNode;
            queue.remove();
            queue.add(node.left);
            queue.add(temNode);
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}