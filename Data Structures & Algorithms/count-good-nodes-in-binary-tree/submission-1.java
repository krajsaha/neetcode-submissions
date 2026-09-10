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
    void trav(TreeNode root,int[] ans,int max){
        if(root==null){
            return;
        }
        if(root.val>=max){
            ans[0]++;
            
        }
        max=Math.max(root.val,max);
        
        trav(root.left,ans,max);
        trav(root.right,ans,max);
    }
    public int goodNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int[] ans=new int[]{0};
        int max = Integer.MIN_VALUE;
        trav(root,ans,max);

        return ans[0];
    }
}
