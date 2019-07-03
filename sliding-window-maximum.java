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
    
    // Optimized
     // tc -> n,  since each element is processed exactly twice - it's index added and then removed from the deque.
    //sc-> n  since O(N−k+1) is used for an output array and O(k) for a deque. 
    public int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
}

