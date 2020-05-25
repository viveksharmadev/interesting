// https://leetcode.com/problems/minimum-size-subarray-sum/
class minimum-size-subarray-sum {
    //Brute force and Time Limit Exceeded
    // tc -> n^3, sc-> 1
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += nums[k];
                }
                if(sum >= s){
                    res = Math.min(res, j-i+1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    // tc -> n, sc-> 1
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, start = 0, end = 0, minLength = Integer.MAX_VALUE;
        
        while(end < nums.length){
            sum += nums[end++];
            while(sum >= s){                
                minLength = Math.min(minLength, end-start);                
                sum-=nums[start++];
            }
        }
        
        return minLength==Integer.MAX_VALUE ? 0 : minLength;
    }
}
