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
    
 
    /*
    Intution - we need to acheive logn complexity, it means we may find mid 
    now once we find mid, we can check its neighbor to understand next level of intution
    lets say mid is odd means before that, subarray length is even, in this case we can compare 
    nums at mid with nums at mid-1, if they are not equal then there is a high chance that number
    at mid is output, then limit our search say end = mid, let start be unchanged means still 0. again calculate mid in loop, this time mid again should be odd, and numbers at mid and mid-1 should equal so say start = mid+2, because if 2 numbers are equal then the next culprit would be currIndex+2 only. 
    */
    // tc - > logn, sc-> 1
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1;        
        while(start < end){
            int mid = start + (end-start)/2;
            
            if(mid%2==1) mid = mid-1;
            
            if(nums[mid]!=nums[mid+1]){
                end = mid;
            }else{
                start = mid+2;
            }
        }
        return nums[start];
    }
}



