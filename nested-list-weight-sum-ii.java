// https://leetcode.com/problems/nested-list-weight-sum-ii/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class nested-list-weight-sum-ii {
    // tc -> n, sc-> n
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<List<NestedInteger>> q = new LinkedList<>();
        q.offer(nestedList);
        int sum = 0, singleSum = 0; 
        while(!q.isEmpty()){
            int size = q.size();
        for(int i=0; i<size; i++){    
        List<NestedInteger> list = q.poll();
        for(NestedInteger ni : list){            
            if(ni.isInteger()){
                singleSum += ni.getInteger();
            }else{
                q.offer(ni.getList());
            }
        }
        }
            sum += singleSum;
        }
        return sum;
    }
}
