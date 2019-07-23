// https://leetcode.com/problems/merge-k-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class merge-k-sorted-lists {
    //  // tc -> nlogk, sc-> 1
    public ListNode mergeKLists(ListNode[] lists) {
        return getMergedKLists(lists, 0, lists.length-1);
    }
    
    private ListNode getMergedKLists(ListNode[] lists, int start, int end){
        if(start > end) return null;
        if(start==end) return lists[start];
        int mid = start + (end-start)/2;
        ListNode l1 = getMergedKLists(lists, start, mid);
        ListNode l2 = getMergedKLists(lists, mid+1, end);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode list1, ListNode list2){
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1!=null) curr.next = list1;
        if(list2!=null) curr.next = list2;
        return res.next;
    }
}
