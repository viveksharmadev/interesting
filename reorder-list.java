// https://leetcode.com/problems/reorder-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // tc -> n, sc-> 1
    public void reorderList(ListNode head) {
        if(head==null) return;
        // find middle
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse second half
        ListNode head2 = reverse(slow.next);
        // don't forget this else these halves will not seperate
        slow.next = null;
        
        // Stitch together both halves
        while(head!=null && head2!=null){
            ListNode temp = head.next;
            ListNode temp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = temp;
            head2 = temp2;
        }        
    }
    
    ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node!=null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
