package leetcode.jianzhiOffer;

public class T47 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0){
            root = null;
        }
        return root;
    }
}
