package leetcode;

public class T124 {
    //二叉树中的最大路径和
    int maxPathLen = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //dfs遍历找到左子树的最长路径和右子树的最长路径，相加，对比maxPathLen，然后返回左右子树更长的一份。
        dfs(root);
        return maxPathLen;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        maxPathLen = Math.max(leftLen+rightLen+root.val,maxPathLen);
        int resVal = root.val + Math.max(leftLen,rightLen);
        if (resVal <= 0) return 0;
        else return resVal;
    }
}
