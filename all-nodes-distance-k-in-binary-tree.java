// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class all-nodes-distance-k-in-binary-tree {
    // tc -> n sc-> n
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildGraph(parentMap, root, null);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
                if(level==K) return getListFromQ(q);
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                
                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                
                TreeNode parent = parentMap.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.offer(parent);
                    visited.add(parent);                    
                }
            }
            level++;
            
        }
        return new ArrayList<Integer>();
    }
    
    private List<Integer> getListFromQ(Queue<TreeNode> q){
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);    
        }
        return res;
    }
    
    private void buildGraph(Map<TreeNode, TreeNode> parentMap, 
                            TreeNode node, TreeNode parentNode){
        if(node==null ) return;
        parentMap.put(node, parentNode);
        buildGraph(parentMap, node.left, node);
        buildGraph(parentMap, node.right, node);
    }
}
