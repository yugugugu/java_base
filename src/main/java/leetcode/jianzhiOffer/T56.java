package leetcode.jianzhiOffer;

import java.util.HashSet;
import java.util.Set;

public class T56 {
    public boolean res = false;
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        inorder(root,k,set);
        return res;
    }

    private void inorder(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return;

        inorder(root.left,k,set);
        if (set.contains(k-root.val)){
            res = true;
            return;
        }
        set.add(root.val);
        inorder(root.right,k,set);
    }
}
