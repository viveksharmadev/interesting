// https://leetcode.com/problems/swap-nodes-in-pairs/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class swap-nodes-in-pairs {
    // tc -> n, sc-> 1
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        while(head!=null && head.next!=null){
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            prev.next = next;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
}
