// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {  
        //if(head.next==null && n==1) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while(n-- >0){
            //System.out.println("first => "  + first.val);
            first = first.next;
        }
        
        while(first!=null && first.next!=null){
            //System.out.println("second => "  + second.val);
            second = second.next;
            first = first.next;
        }
        
        if(second!=null && second.next!=null)
        second.next = second.next.next;
        
        return dummy.next;
    }
}
