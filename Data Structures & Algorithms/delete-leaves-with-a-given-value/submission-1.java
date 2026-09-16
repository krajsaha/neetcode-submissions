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
    boolean isLeaf(TreeNode node){
        if(node==null){
            return false;
        }
        return node.left==null && node.right==null;
    }
    public TreeNode removeLeafNodes1(TreeNode root, int target) {
        if(root==null){
            return null;
        }
        TreeNode left = removeLeafNodes1(root.left,target);
        TreeNode right = removeLeafNodes1(root.right,target);

        if(isLeaf(left) && left.val==target){
            root.left=null;
        }

        if(isLeaf(right) && right.val==target){
            root.right=null;
        }
        return root;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return null;
        }
        removeLeafNodes1(root,target);

        if(root.val==target){
            return null;
        }
        return root;
    }
}