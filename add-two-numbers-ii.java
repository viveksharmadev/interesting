// https://leetcode.com/problems/add-two-numbers-ii/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class add-two-numbers-ii {
    // tc -> m+n, sc-> m+n
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(l1!=null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2);
            l2 = l2.next;
        }
        
        int carry = 0; ListNode prev = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int a = !stack1.isEmpty() ? stack1.pop().val : 0;
            int b = !stack2.isEmpty() ? stack2.pop().val : 0;
            int sum = a+b+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            node.next = prev;
            prev = node;
        }
        return prev;
    }
}
