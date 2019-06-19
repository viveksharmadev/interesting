//https://leetcode.com/problems/jump-game/
class Solution {
     // tc -> 2^n, sc-> n
   public boolean canJump(int[] nums) {
       return canJumpFromPos(nums, 0);//, new Boolean[nums.length]);
   }
   
   private boolean canJumpFromPos(int[] nums, int index){
       //, Boolean[] cache){
       if(index==nums.length-1) return true;
       //if(cache[index]!=null) return cache[index];
       int furthestJump = Math.min(index+nums[index], nums.length-1);
       
       for(int i=index+1; i<=furthestJump; i++){
           if(canJumpFromPos(nums, i)){
               return true;
           }
       }
       //cache[index] = false;
       return false;
   }
   
    // tc -> n^2, sc-> n(cache)+n(recursion stack)=n
    public boolean canJump(int[] nums) {
       return canJumpFromPos(nums, 0, new Boolean[nums.length]);
   }
   
   private boolean canJumpFromPos(int[] nums, int index, Boolean[] cache){
       if(index==nums.length-1) return true;
       if(cache[index]!=null) return cache[index];
       int furthestJump = Math.min(index+nums[index], nums.length-1);
       
       for(int i=index+1; i<=furthestJump; i++){
           if(canJumpFromPos(nums, i, cache)){
               return true;
           }
       }
       cache[index] = false;
       return false;
   }
   
    // tc -> n, sc->1
    public boolean canJump(int[] nums) {
        int dist = 0;
        for(int i=0; i<=dist; i++){
            dist = Math.max(dist, i+nums[i]);
            if(dist >= nums.length-1) return true;
        }
        return false;
    }
    
   
}
