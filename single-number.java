// https://leetcode.com/problems/single-number/

class Solution {
    // tc -> n, sc -> 1
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}
