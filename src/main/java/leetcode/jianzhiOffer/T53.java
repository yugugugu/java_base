package leetcode.jianzhiOffer;

public class T53 {
    public static void main(String[] args) {
        T53 t53 = new T53();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        t53.inorderSuccessor(root,root.left);
    }
    public TreeNode nextNode;
    public int target;
    public TreeNode pre;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        target =p.val;
        inorder(root);
        return nextNode;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (pre!=null && pre.val == target ) nextNode = root;
        pre = root;
        inorder(root.right);

    }
}
