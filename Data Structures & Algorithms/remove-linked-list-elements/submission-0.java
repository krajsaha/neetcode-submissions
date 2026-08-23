class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a fake node pointing to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Use a pointer to traverse the list
        ListNode prev = dummy;
        
        while (prev.next != null) {
            if (prev.next.val == val) {
                // Skip the matching node
                prev.next = prev.next.next;
            } else {
                // Only move forward if we didn't delete a node
                prev = prev.next;
            }
        }
        
        // Return the actual new head
        return dummy.next;
    }
}
