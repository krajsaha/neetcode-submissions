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
    void InOrder(TreeNode root,List<Integer> op){
        if(root==null){
            return;
        }
        
        InOrder(root.left,op);
        op.add(root.val);
        InOrder(root.right,op);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> op = new ArrayList<>();

        InOrder(root,op);
        System.out.println(op);
        return op.get(k-1);
    }
}
