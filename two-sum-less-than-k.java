// https://leetcode.com/problems/two-sum-less-than-k/

class two-sum-less-than-k {
    // tc -> n^2, sc-> n
    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                int sum = A[i]+A[j];
                if(sum < K){
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }
    // tc -> nlogn, sc-> n
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int start = 0, end = A.length-1, res = Integer.MIN_VALUE;;
        while(start < end){
            int sum = A[start]+A[end];
            if(sum < K){
                res = Math.max(res, sum);
                start++;
            }else{
                end--;
            }
        }
        return res==Integer.MIN_VALUE ? -1 : res;
    }
}
