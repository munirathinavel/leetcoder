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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        merge(list1, list2, res);
        return res.next;
    }
    
    private void merge(ListNode l1, ListNode l2, ListNode l3) {
        if(l1 == null) {
            l3.next = l2;
        } else if(l2 == null) {
            l3.next = l1;
        } else {
            if(l1.val > l2.val) {
                l3.next = l2;
                merge(l1, l2.next, l3.next);
            } else {
                l3.next = l1;
                merge(l1.next, l2, l3.next);
            }
        }
    }
}