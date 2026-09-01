/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    void po(List<Integer> op, Node root){
        if(root==null){
            return;
        }
        for(Node child : root.children){
            po(op,child);
        }
        op.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> op = new ArrayList<>();

        po(op,root);
        return op;
    }
}