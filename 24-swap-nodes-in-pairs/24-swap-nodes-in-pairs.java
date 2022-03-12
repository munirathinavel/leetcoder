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
    public ListNode swapPairs(ListNode head) {
        // Base Condition - return 
        if(head == null || head.next == null) {
            return head;
        }
        // Assign variables
        ListNode prev = head;
        ListNode current = head.next;
        ListNode next = current.next;
        
        // Updating links
        prev.next = next;
        current.next = prev;
        
        // Goto next remaining list
        if(next != null) {
           prev.next = swapPairs(next); 
        }
        // return current (new head)
        return current;
    }
}