// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
/*
Pattern - Use stack to keep a track of next when child got found
need to handle only 2 conditions:
1. When child is not null
2. when curr next is null means we reach to the tail of curr node through child node
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    // tc -> n, sc-> n
    public Node flatten(Node head) {
        Node curr = head;
        Stack<Node> stack = new Stack<>();
        
        while(curr!=null){
            if(curr.child!=null){
                stack.push(curr.next);
                curr.next = curr.child;
                if(curr.next!=null) curr.next.prev = curr;
                curr.child = null; // Imp
            }else if(curr.next==null && !stack.isEmpty()){
                curr.next = stack.pop();
                if(curr.next!=null) curr.next.prev = curr;
            }
            curr = curr.next;
        }        
        return head;
    }
    
    // Same code just another view:
     // tc -> n, sc-> n
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while(curr!=null){
            if(curr.child!=null){
                stack.push(curr.next); 
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;                
            }else if(!stack.isEmpty() && curr.next==null){
                    Node node = stack.pop();
                    curr.next = node;
                    if(node!=null) node.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
