//https://leetcode.com/problems/subarray-sum-equals-k/
class subarray-sum-equals-k {
    
     // tc -> n^2, sc-> 1
    public int subarraySum(int[] nums, int k) {
        int count = 0,  n = nums.length;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    
    // Better
    // tc -> n, sc-> n
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k))
                res += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        
        return res;
    }
}
