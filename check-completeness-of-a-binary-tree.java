// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class check-completeness-of-a-binary-tree {
    // tc -> n, sc-> n
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty() && q.peek()!=null){
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
        }
        
        while(!q.isEmpty() && q.peek()==null) {
            q.poll();
        }
        
        return q.isEmpty();
    }
}
