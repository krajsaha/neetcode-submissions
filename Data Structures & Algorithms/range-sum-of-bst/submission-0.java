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
    void pre(TreeNode root, int low, int high,int[] ans){
        if(root==null){
            return;
        }

        if(root.val>=low && root.val<=high){
            ans[0]+=root.val;
        }

        pre(root.left,low,high,ans);
        pre(root.right,low,high,ans);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] ans = new int[]{0};
    pre(root,low,high,ans);
        return ans[0];
    }
}