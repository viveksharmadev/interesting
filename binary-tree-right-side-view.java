// https://leetcode.com/problems/binary-tree-right-side-view/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class binary-tree-right-side-view {
    // tc -> n, sc-> n
    int height = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        setRightSideViewList(root, 1, res);
        return res;
    }
    
    private void setRightSideViewList(TreeNode root, int depth, List<Integer> res){
        if(root==null) return;
        if(height<depth){
            res.add(root.val); 
            height = depth;
        }
        setRightSideViewList(root.right, depth+1, res);
        setRightSideViewList(root.left, depth+1, res);
    }
}
