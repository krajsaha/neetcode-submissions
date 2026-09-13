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
    TreeNode buildTreex(int[] preorder, int[] inorder,int[] idx,int s,int e,HashMap<Integer,Integer> map){
        if(idx[0]>=preorder.length){
            return null;
        }
        if(s>e){
            return null;
        }
        int pVal = preorder[idx[0]];
        TreeNode root = new TreeNode(pVal);
        idx[0]++;
        root.left=buildTreex(preorder,inorder,idx,s,map.get(pVal)-1,map);
        root.right=buildTreex(preorder,inorder,idx,map.get(pVal)+1,e,map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int idx[] = new int[]{0};
        return buildTreex(preorder,inorder,idx,0,preorder.length-1,map);
    }
}
