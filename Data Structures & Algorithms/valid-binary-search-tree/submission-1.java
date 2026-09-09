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
    void isBst(TreeNode root,List<Integer> op,boolean[] flag){
        if(root==null){
            return;
        }

        isBst(root.left,op,flag);

        if(op.size()>0 && op.get(op.size()-1)>=root.val){
            flag[0]=false;
        }

        op.add(root.val);

        isBst(root.right,op,flag);

    }
    public boolean isValidBST(TreeNode root) {
        boolean[] flag = new boolean[]{true};
        List<Integer> op = new ArrayList<>();

        isBst(root,op,flag);
        return flag[0];
    }
}
