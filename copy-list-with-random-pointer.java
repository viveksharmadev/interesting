/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
https://leetcode.com/problems/copy-list-with-random-pointer/
*/
class copy-list-with-random-pointer {
    // tc -> n, sc-> n
    public Node copyRandomList(Node head) {
        Map<Node, Node> cache = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            cache.put(curr, new Node(curr.val, curr.next, curr.random));
            curr = curr.next;
        }
        curr = head;
        while(curr!=null){
            cache.get(curr).next = cache.get(curr.next);
            cache.get(curr).random = cache.get(curr.random);
            curr = curr.next;
        }
        return cache.get(head);
    }
}
