// https://leetcode.com/problems/single-element-in-a-sorted-array/
class single-element-in-a-sorted-array {
    // tc -> n, sc-> n
    // Need Optimized method
    public int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num,0)+1);
        }
        
        for(int num : nums){
            if(countMap.get(num)==1) return num;
        }
        
        return -1;
    }
}
