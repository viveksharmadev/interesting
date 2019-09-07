//https://leetcode.com/problems/find-all-duplicates-in-an-array/
class Solution {
    // tc -> n, sc-> n
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0) res.add(index+1);
            nums[index] = -nums[index];
        }
        return res;
    }
}
