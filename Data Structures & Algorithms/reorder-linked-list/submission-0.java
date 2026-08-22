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
    ListNode reverse(ListNode head,ListNode prev){

        if(head==null){
            return prev;
        }

        ListNode curr = head;
        head=head.next;
        curr.next=prev;

        return reverse(head,curr);
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){

            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode l2 = reverse(slow.next,null);
        slow.next=null;
        
        while(head!=null && l2!=null){
            ListNode temphead = head.next;
            ListNode templ2 = l2.next;
            head.next=l2;
            head=head.next;
            head.next=temphead;
            head=head.next;
            l2=templ2;


        }

        

        
    }
}
