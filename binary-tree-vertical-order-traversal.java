// https://leetcode.com/problems/binary-tree-vertical-order-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class binary-tree-vertical-order-traversal {
    // tc -> n, sc-> n
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Queue<Integer> indices = new LinkedList<>();
        indices.offer(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max =0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int index = indices.poll();
                TreeNode node = q.poll();
                map.putIfAbsent(index, new ArrayList<Integer>());
                map.get(index).add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    indices.offer(index-1);
                    min = Math.min(min, index-1);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    indices.offer(index+1);
                    max = Math.max(max, index+1);
                }
            }            
        }
        
        for(int i=min; i<=max; i++){
            res.add(map.get(i));
        }
        
        return res;
    }
}
