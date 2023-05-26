package leetcode.jianzhiOffer;

import java.util.Stack;

public class T52 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        increasingBST(root);
    }
    public static TreeNode increasingBST(TreeNode root) {
        //用栈实现一下中序遍历
        Stack<TreeNode> stack = new Stack<>();

        TreeNode head = new TreeNode();
        TreeNode point = head;
        while (!stack.isEmpty()||root!=null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                point.right = node;
                point.left = null;
                point = node;
                root = node.right;
            }
        }
        point.left = null;
        return head.right;
    }
}
