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

    TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return null;
        }

        
        int root1Val = root1==null ? 0 : root1.val;
        int root2Val = root2==null ? 0 : root2.val;
        TreeNode root = new TreeNode(root1Val+root2Val);
        TreeNode r1l=root1==null ? null : root1.left;
        TreeNode r2l=root2==null ? null : root2.left;
        TreeNode r1r=root1==null ? null : root1.right;
        TreeNode r2r=root2==null ? null : root2.right;
        root.left = merge(r1l,r2l);
        root.right = merge(r1r,r2r);

        return root;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }
}