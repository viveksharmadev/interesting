// https://leetcode.com/problems/maximum-subarray/
class maximum-subarray {
    // tc -> n, sc-> 1
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], max = nums[0];
        for(int i=1; i<nums.length; i++){
            maxSoFar = Math.max(nums[i], nums[i]+maxSoFar);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}
