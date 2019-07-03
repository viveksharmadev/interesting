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
}
