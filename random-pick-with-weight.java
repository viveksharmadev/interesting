// https://leetcode.com/problems/random-pick-with-weight/
class Solution {

    Random random; int[] wSums;
    // tc-> n for init, logn for pickIndex
    // sc-> n
    public Solution(int[] w) {
        this.random = new Random();
        for(int i=1; i<w.length; i++){
            w[i] += w[i-1];
        }
        this.wSums = w;
    }
    
    public int pickIndex() {
        int len = wSums.length;
        int idx = random.nextInt(wSums[len-1])+1;
        int left = 0, right = len-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(wSums[mid]==idx) return mid;
            else if(idx>wSums[mid]) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
