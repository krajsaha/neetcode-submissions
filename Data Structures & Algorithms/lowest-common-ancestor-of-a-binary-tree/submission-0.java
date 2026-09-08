/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean path(TreeNode root,ArrayList<TreeNode> arr,TreeNode n){

        if(root==null){
            return false;
        }
        arr.add(root);
        if(root==n){
            return true;
        }
        if( path(root.left,arr,n)|| path(root.right,arr,n)) {
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<TreeNode> arrp = new ArrayList<>();
        ArrayList<TreeNode> arrq = new ArrayList<>();

        if(!path(root,arrp,p) || !path(root,arrq,q)){
            return null;
        }
        

        int idx = Math.min(arrp.size(),arrq.size())-1;

        while(idx>=0){
            if(arrp.get(idx)==arrq.get(idx)){
                return arrp.get(idx);
            }
            idx--;
        }
        return null;
    }
}