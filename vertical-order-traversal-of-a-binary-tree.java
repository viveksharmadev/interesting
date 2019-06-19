// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class vertical-order-traversal-of-a-binary-tree {
    // tc -> n, sc-> n
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Queue<Integer> cols = new LinkedList<>();
        cols.offer(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            Map<Integer, PriorityQueue<Integer>> tempMap = new HashMap<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                int index = cols.poll();
                tempMap.putIfAbsent(index, new PriorityQueue<Integer>());
                tempMap.get(index).add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    cols.offer(index-1);
                    min = Math.min(index-1, min);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    cols.offer(index+1);
                    max = Math.max(index+1, max);
                }
            }
            
            for(int key : tempMap.keySet()){
                PriorityQueue<Integer> pq = tempMap.get(key);
                while(pq!=null && !pq.isEmpty()){
                    map.putIfAbsent(key, new ArrayList<Integer>());
                    map.get(key).add(pq.poll());
                }
            }
        }
        
        for(int i=min; i<=max; i++){
            res.add(map.get(i));
        }
        return res;
    }
}
