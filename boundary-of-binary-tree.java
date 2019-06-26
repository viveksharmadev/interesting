// https://leetcode.com/problems/boundary-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class boundary-of-binary-tree {
    // tc -> n, sc-> n
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        res.add(root.val);
        left(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        right(root.right, res);  
        return res;
    }
    
    private void left(TreeNode root, List<Integer> res){
        if(root==null || (root.left==null && root.right==null)) return;
        res.add(root.val);
        if(root.left==null)
            left(root.right, res);
        else
            left(root.left, res);
    }
    
    private void right(TreeNode root, List<Integer> res){
        if(root==null || (root.left==null && root.right==null)) return;        
        if(root.right==null)
            right(root.left, res);
        else
            right(root.right, res);
        res.add(root.val);
    }
    
    private void leaves(TreeNode root, List<Integer> res){
        if(root==null)                    return;
        if(root.left==null && root.right==null)
            res.add(root.val);
        leaves(root.left, res);
        leaves(root.right, res);
    }
}
