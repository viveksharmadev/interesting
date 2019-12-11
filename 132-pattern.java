https://leetcode.com/problems/132-pattern/
class Solution {
    // tc -> n^3, sc-> 1
    public boolean find132pattern(int[] nums) {
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]<nums[k] && nums[k]<nums[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // tc -> n^2, sc-> 1
    public boolean find132pattern(int[] nums) {        
        int min = Integer.MAX_VALUE;
            for(int j=0; j<nums.length-1; j++){
                min = Math.min(nums[j], min);
                for(int k=j+1; k<nums.length; k++){
                    if(min<nums[k] && nums[k]<nums[j]){
                        return true;
                    }
                }
            }
        return false;
    }
}
