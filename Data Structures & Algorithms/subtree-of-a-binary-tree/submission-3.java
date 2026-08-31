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
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null){
            return true;
        }

        if(root==null && subRoot!=null){
            return false;
        }

        if(root!=null && subRoot==null){
            return false;
        }


        return root.val==subRoot.val && isSubtree2(root.left,subRoot.left) && isSubtree2(root.right,subRoot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
if(root==null && subRoot==null){
            return true;
        }

         if(root==null && subRoot!=null){
            return false;
        }

        if(root!=null && subRoot==null){
            return false;
        }

         return  isSubtree2(root,subRoot) || isSubtree(root.right,subRoot) || isSubtree(root.left,subRoot);

    }
}
