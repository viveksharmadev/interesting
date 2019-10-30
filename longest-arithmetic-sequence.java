// https://leetcode.com/problems/longest-arithmetic-sequence/
class longest-arithmetic-sequence {
// tc -> n^3, sc-> 1
    public int longestArithSeqLength(int[] A) {
        int n = A.length, max = 1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int count = 1;
                int currIndex = j;
                int prevIndex = i;
                int diff = A[i]-A[j];
                while(currIndex < n){
                    if(A[prevIndex]-A[currIndex]==diff){
                        prevIndex = currIndex;
                        count++;
                    }
                    currIndex++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
    // tc-> n, sc -> n
    public int longestArithSeqLength(int[] A) {
        int res = 1, n = A.length;
        Map<Integer, Integer>[] maps = new HashMap[n];
        for(int i=0; i<n; i++){
            maps[i] = new HashMap<>();
            for(int j=0; j<i; j++){
                int diff = A[i]-A[j];
                maps[i].put(diff, maps[j].getOrDefault(diff,1)+1);
                res = Math.max(res, maps[i].get(diff));
            }            
        }
        return res;
    }
}
