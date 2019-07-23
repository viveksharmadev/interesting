// https://leetcode.com/problems/path-sum-ii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class path-sum-ii {
    // tc -> n, sc-> n
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        setPathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void setPathSum(TreeNode root, int rem, List<Integer> list,
                           List<List<Integer>> res){
        if(root==null) return;
        list.add(root.val);
        if(root.left==null && root.right==null && rem-root.val==0){
            res.add(new ArrayList(list)); 
        }
        setPathSum(root.left, rem-root.val, list, res);
        setPathSum(root.right, rem-root.val, list, res);
        list.remove(list.size()-1);
    }
}
