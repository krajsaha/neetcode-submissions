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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode slow=head;
        ListNode prev=null;
        int k =0;

        while(k<n){
            first=first.next;
            k++;
        }

        if(first==null){
            return slow.next;
        }

        while(first!=null){
            first=first.next;
            prev=slow;
            slow=slow.next;
        }

        prev.next=slow.next;

        return head;
    }
}
