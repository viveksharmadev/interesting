// https://leetcode.com/problems/sliding-window-maximum/
// Need to optimize this solution
class sliding-window-maximum {
    // tc -> n*k, sc-> n-k+1
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0) return new int[]{};
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0; i<n-k+1; i++){
            int count = 0, j=i, max = Integer.MIN_VALUE;
            while(count < k && j<n){
                max = Math.max(max, nums[j++]);
                count++;               
            }
            res[i] = max;
        }
        return res;
    }
}
