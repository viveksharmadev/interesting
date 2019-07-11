// https://leetcode.com/problems/move-zeroes/

class Solution {
    // tc -> n, sc-> 1
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        
        while(j<nums.length){
            nums[j++] = 0;
        }
        
    }
    
     // By Swapping
    // tc -> n, sc-> 1
    public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
        return;
    }
    
    int cur = 0;

    for (int i = 0; i < nums.length; ++i) {
        if (nums[i] != 0) {
            int temp = nums[cur];
            nums[cur++] = nums[i];
            nums[i] = temp;
        }
    }
}
 
}
