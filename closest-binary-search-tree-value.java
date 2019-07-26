// https://leetcode.com/problems/closest-binary-search-tree-value/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class closest-binary-search-tree-value {
    // tc -> logn, sc-> logn or n if flatten tree
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root!=null){
            if(Math.abs(target-root.val) < Math.abs(target-res))
                res = root.val;
            if(target < root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }
}
