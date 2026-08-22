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
    ListNode reverse(ListNode head, ListNode prev) {
        if(head == null) {
            return prev;
        }

        ListNode curr = head;
            head = head.next;
            curr.next=prev;
            return reverse(head, curr);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }

        if(l2==null){
            return l1;
        }
        int off=0;
        ListNode dummy = new ListNode(99999);
        ListNode head=dummy;
        
        while(l1!=null || l2!=null || off!=0){

            int val1 = l1!=null ? l1.val : 0;
            int val2 = l2!=null ? l2.val : 0;

            int val = (val1+val2+off);
             off=val/10;
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

        return dummy.next;
    }
}
