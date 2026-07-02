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
    int getH(TreeNode root,int[] dia){

        if(root==null){
            return 0;
        }

        int lh=getH(root.left,dia);
        int rh = getH(root.right,dia);

        dia[0] = Math.max(dia[0],lh+rh);

        return Math.max(lh,rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[]{0};
        getH(root,dia);
        return dia[0];
    }
}
