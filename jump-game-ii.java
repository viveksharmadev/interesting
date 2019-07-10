// https://leetcode.com/problems/jump-game-ii/

class jump-game-ii {
    // tc -> n, sc -> 1
    public int jump(int[] nums) {
        int currFarthest=0, currEnd=0, jump=0;
        if(nums.length<2) return jump;
        for(int i=0; i<nums.length; i++){
            currFarthest = Math.max(currFarthest, i+nums[i]);
            if(i==currEnd){
                currEnd = currFarthest;
                jump++;
                if(currEnd>=nums.length-1) return jump;
            }
        }
        return jump;
    }
    
   // BFS type:
    // tc -> n, sc-> 1
   public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int curMax = 0; // to mark the last element in a level
        int level = 0, i = 0;
        while (i <= curMax) { 
            int furthest = curMax; // to mark the last element in the next level
            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) return level + 1;
            }
            level++;
            curMax = furthest;
        }
        return -1; // if i < curMax, i can't move forward anymore (the last element in the array can't be reached)
    }
}
