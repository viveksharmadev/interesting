// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class binary-tree-zigzag-level-order-traversal {
    // tc -> n, sc-> n
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isZigZag = false;
        while(!q.isEmpty()){            
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(!isZigZag){
                    list.add(node.val);            
                }else{
                    list.add(0,node.val);
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            isZigZag = !isZigZag;
            res.add(list);
        }
    return res;
    }
}
