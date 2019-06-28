// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class populating-next-right-pointers-in-each-node {
    public Node connect(Node root) {
        // tc -> n, sc-> n
        Node curr = root;
        while(curr!=null){
            Node level = curr;
            while(level!=null){
                if(level.left!=null)
                    level.left.next = level.right;
                if(level.right!=null && level.next!=null)
                    level.right.next = level.next.left;
                level = level.next;
            }
            curr = curr.left;
        }
        return root;
    }
}
