// https://leetcode.com/problems/reverse-nodes-in-k-group/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class reverse-nodes-in-k-group {
    // tc -> n, sc-> n
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while(curr!=null && count!=k){
            curr = curr.next;
            count++;
        }
        
        if(count==k){
            curr = reverseKGroup(curr, k);
            while(count-- > 0){
             ListNode next = head.next;
             head.next = curr;
             curr = head;
             head = next;
           }       
            head = curr;
        }
        
        return head;
    }   
}
