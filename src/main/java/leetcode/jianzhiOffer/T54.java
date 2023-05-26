package leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class T54 {
    List<TreeNode> nodeList;
    List<Integer> sumList;
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //中序遍历获得前缀和
        nodeList = new ArrayList<>();
        sumList = new ArrayList<>();
        inorder(root);
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode tem = nodeList.get(i);
            tem.val = sum - sumList.get(i);
        }
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        sumList.add(sum);
        nodeList.add(root);
        sum += root.val;

        inorder(root.right);
    }
}
