package leetcode.jianzhiOffer;

import jdk.nashorn.internal.ir.ReturnNode;

public class T49 {
    public int sum;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root,int temsum) {
      if (root.left == null && root.right == null){
            sum += temsum*10 + root.val;
            return;
      }
      if (root.left != null) dfs(root.left,temsum*10+root.val);
      if (root.right != null) dfs(root.right,temsum*10+root.val);
    }
}
