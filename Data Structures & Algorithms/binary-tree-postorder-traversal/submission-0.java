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
    void trav(List<Integer> op,TreeNode root){
        if(root==null){
            return;
        }
        trav(op,root.left);
        trav(op,root.right);
        op.add(root.val);
        
        
        
        
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();

        trav(op,root);
        return op;
    }
}