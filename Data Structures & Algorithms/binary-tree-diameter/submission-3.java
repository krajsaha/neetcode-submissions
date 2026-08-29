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
    int height(TreeNode root,int[] ans){
        if(root==null){
            return 0;
        }

        int lh = height(root.left,ans);
        int rh = height(root.right,ans);

        ans[0]=Math.max(lh+rh,ans[0]);

        return Math.max(lh,rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans=new int[]{0};

        height(root,ans);
        return ans[0];
    }
}
