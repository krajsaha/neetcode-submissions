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
    int postOrder(TreeNode root,int[] ans){
        if(root==null){
            return 0;
        }

        int left = Math.max(postOrder(root.left,ans),0);
        int right = Math.max(postOrder(root.right,ans),0);

        //int rootVal = root.val<0 ? 0 : root.val;
        int sum = left+right+root.val;

        ans[0]=Math.max(ans[0],sum);

        return Math.max(left,right)+root.val;

    }
    public int maxPathSum(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};

        postOrder(root,ans);
        return ans[0];
    }
}
