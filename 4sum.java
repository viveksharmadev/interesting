//https://leetcode.com/problems/4sum/
class 4sum {
    // tc -> n^3, sc-> n
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int start = j+1, end = nums.length-1;
                while(start < end){
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum<target)
                        start++;
                    else if(sum>target)
                        end--;
                    else{
                        while(start<nums.length-1 && nums[start]==nums[start+1]) start++;
                        while(end>0 && nums[end]==nums[end-1]) end--;
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++; end--;
                    }
                }                
            }
        }
        return res;
    }
}
