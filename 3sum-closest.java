// https://leetcode.com/problems/3sum-closest/
class 3sum-closest {
    // tc -> n^2, sc-> 1
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int res = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int start = i+1, end = nums.length-1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(Math.abs(target-sum) < Math.abs(target-res)){
                    res = sum;                    
                }
                if(sum<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return res;
    }
}
