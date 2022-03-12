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
        // Initialize node variables
        ListNode prev = null;
        ListNode first = head;
        ListNode second = head.next;
        head = second;
        
        while(first != null && second != null) {
            first.next = second.next;
            second.next = first;
            if(prev != null) {
                prev.next = second;
            }
            // Update pointers
            prev = first;
            first = first.next;
            if(first != null) {
                second = first.next;    
            }
        } 
        return head;
    }
}