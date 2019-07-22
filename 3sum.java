// https://leetcode.com/problems/3sum/

class 3sum {
    // tc -> n^2, sc-> n
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1, right = nums.length-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    while(left<nums.length-1 && nums[left]==nums[left+1]) left++;
                    while(right>0 && nums[right]==nums[right-1]) right--;
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
