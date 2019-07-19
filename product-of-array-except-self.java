// https://leetcode.com/problems/product-of-array-except-self/
class product-of-array-except-self {
    // tc -> n, sc-> n
    public int[] productExceptSelf(int[] nums) {
        int left = 1; int[] res = new int[nums.length];
        res[0] = left;
        for(int i=1; i<nums.length; i++){
            left *= nums[i-1];
            res[i] = left;
        }
        
        int right = 1;
        res[nums.length-1] = left;        
        for(int i=nums.length-2; i>=0; i--){
            right *= nums[i+1];
            res[i] *= right;
        }
        
        return res;
    }
}
