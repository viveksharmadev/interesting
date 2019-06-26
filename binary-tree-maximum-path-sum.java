// https://leetcode.com/problems/binary-tree-maximum-path-sum/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class binary-tree-maximum-path-sum {
    // tc -> n, sc-> n
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return max;
    }
    
    private int calculateMaxPathSum(TreeNode node){
        if(node==null) return 0;
        int left = Math.max(0, calculateMaxPathSum(node.left));
        int right = Math.max(0, calculateMaxPathSum(node.right));
        max = Math.max(max, left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}
