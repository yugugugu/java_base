package leetcode;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94 {
    //中序遍历，练习一下用栈实现把
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty()|| p != null){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()){
                p = stack.pop();
                inorderList.add(p.val);
                p = p.right;
            }
        }
        return inorderList;
    }
}
