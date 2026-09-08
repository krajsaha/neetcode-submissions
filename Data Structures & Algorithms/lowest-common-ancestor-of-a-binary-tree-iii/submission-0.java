/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {

    public Node lowestCommonAncestor(Node p, Node q) {
        ArrayList<Node> arrp=new ArrayList<>();
        ArrayList<Node> arrq=new ArrayList<>();

        while(p!=null){
            arrp.add(p);
            p=p.parent;
        }
         while(q!=null){
            arrq.add(q);
            q=q.parent;
        }
        Collections.reverse(arrp);
        Collections.reverse(arrq);

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
