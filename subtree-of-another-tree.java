// https://leetcode.com/problems/subtree-of-another-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class subtree-of-another-tree {
    // tc -> m*n , sc->  n (The depth of the recursion tree can go upto n. n refers to the number of nodes in s)
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(isSametree(s,t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    // Using BFS
     // tc -> m*n , sc->  n (The depth of the recursion tree can go upto n. n refers to the number of nodes in s)
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(isSametree(node, t)) return true;
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
        }
        return false;
    }
    
    private boolean isSametree(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val!=t.val) return false;
        return isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }
}
