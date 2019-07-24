// https://leetcode.com/problems/sort-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class sort-list {
    // tc -> nlogn, sc-> n(recursion - divide and conquer i.e. merge sort)
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode list1 = sortList(slow);
        ListNode list2 = sortList(head);
        return merge(list1, list2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1!=null) curr.next = l1;
        if(l2!=null) curr.next = l2;
        return res.next;
    }
}
