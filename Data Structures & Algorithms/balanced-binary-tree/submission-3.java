/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int height(TreeNode root,boolean[] ans){

        if(root==null){
            return 0;
        }

        int lh = height(root.left,ans);
        int rh = height(root.right,ans);

        boolean hd = Math.abs(lh-rh)<=1 ? true : false;
        ans[0] = ans[0] && hd;
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[]{true};

        height(root,ans);

        return ans[0];
    }
}
