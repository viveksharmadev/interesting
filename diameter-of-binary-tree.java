/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //https://leetcode.com/problems/diameter-of-binary-tree/
class diameter-of-binary-tree {
    // tc -> n, sc-> n
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateWidth(root);
        return max;
    }
    
    private int calculateWidth(TreeNode root){
        if(root==null) return 0;
        int left = calculateWidth(root.left);
        int right = calculateWidth(root.right);
        max = Math.max(max, left+right);
        return 1+Math.max(left,right);
    }
}
