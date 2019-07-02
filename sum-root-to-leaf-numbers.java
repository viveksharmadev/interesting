// https://leetcode.com/problems/sum-root-to-leaf-numbers/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class sum-root-to-leaf-numbers {
    // tc -> n, sc-> n
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        countRootToLeavesSum(root, 0);
        return sum;
    }
    
    private void countRootToLeavesSum(TreeNode node, int result){
        if(node==null) return;
        if(node.left==null && node.right==null)
            sum += result*10 + node.val;
        countRootToLeavesSum(node.left, result*10 + node.val);
        countRootToLeavesSum(node.right, result*10 + node.val);
    }
}
