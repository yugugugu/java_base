package leetcode.jianzhiOffer;

import java.time.chrono.IsoChronology;

public class T51 {
    public int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxsum;
    }

    private int getMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int maxleft = getMaxPathSum(root.left);
        int maxright = getMaxPathSum(root.right);

        int temsum = root.val;
        if (maxleft>0) temsum+=maxleft;
        if (maxright>0) temsum+=maxright;
        maxsum = Math.max(temsum,maxsum);
        if(maxleft<=0 && maxright<=0) return root.val;
        return maxleft>maxright?maxleft+root.val:maxright+ root.val;
    }
}
