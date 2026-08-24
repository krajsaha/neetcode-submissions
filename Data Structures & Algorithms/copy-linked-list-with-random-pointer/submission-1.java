/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();

        Node dummy = new Node(-9);
        Node newHead=dummy;
        Node temp=head;


        while(temp!=null){

            Node curr = new Node(temp.val);
            map.put(temp,curr);
            temp=temp.next;
        }
        
        
        while(head!=null){
        newHead.next=map.get(head);
        newHead.next.random=map.get(head.random);
        head=head.next;
        newHead=newHead.next;
            
        }

        return dummy.next;
    }
}
