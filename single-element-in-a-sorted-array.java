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
    
    // Optimized
    // tc -> logn, sc-> 1
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1;
        
        while(start < end){
            int mid = start + (end-start)/2;
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    start = mid+2;
                }else{
                    end = mid;
                }
            }else{
                 if(nums[mid]==nums[mid-1]){
                    start = mid+1;
                }else{
                    end = mid;
                }
            }
        }
        return nums[start];
    }
}
