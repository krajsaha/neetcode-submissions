/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(99);
        ListNode head = dummy;
        int of = 0;
        while(l1!=null || l2!=null || of!=0){

            int l1Val= l1==null ? 0 : l1.val;
            int l2Val= l2==null ? 0 : l2.val;

            int val = (l1Val+l2Val+of);
             of=val/10;
            val=val%10;
            head.next = new ListNode(val);
            head=head.next;
            if(l1!=null){
 l1=l1.next;
            }
           
             if(l2!=null){
 l2=l2.next;
            }
        }
        // while(l1!=null ){

        //     int val = (l1.val+of);
        //      of=val/10;
        //     val=val%10;
        //     head.next = new ListNode(val);
        //     head=head.next;
        //     l1=l1.next;
        // }
        // while(l2!=null){

        //     int val = (l2.val+of);
        //      of=val/10;
        //     val=val%10;
        //     head.next = new ListNode(val);
        //     head=head.next;
        //     l2=l2.next;
        // }

        // if(of!=0){
        //     head.next = new ListNode(of);
        //     head=head.next;
        // }
        return dummy.next;
    }
}
