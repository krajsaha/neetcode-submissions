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

public class Codec {
    void preOrder(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("N");
            sb.append("P");
            return;
        }

        sb.append(root.val);
        sb.append("P");
        preOrder(root.left,sb);
        preOrder(root.right,sb);

        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    TreeNode construct(String[] data,int[] idx){
        if(idx[0]>=data.length){
            return null;
        }
        if(data[idx[0]].equals("N")){
            idx[0]++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(data[idx[0]++]));
        root.left=construct( data,idx);
        root.right=construct( data,idx);
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] datas = data.split("P");
        return construct(datas,new int[]{0});
    }
}
