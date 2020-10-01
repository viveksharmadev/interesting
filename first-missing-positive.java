//https://leetcode.com/problems/first-missing-positive/

class Solution {
    // tc -> n, sc -> 1
    public int firstMissingPositive(int[] nums) {
        // First ignore negatives and numbers more than nums.length
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i] > n || nums[i] <= 0){
                nums[i] = n+1;
            }
        }
        
        // Mark all positive to negatives;
        
        for(int i=0; i<n; i++){
            
            int index = Math.abs(nums[i]);
            
            if(index > n) continue;
            
            index -= 1;
            
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        
        // Find unvisited number means positive number 
          // and return it's index+1 because we need to find number between 1 to n
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0)
                return i+1;
        }
        
        return n+1;
    }
}
