// https://leetcode.com/problems/sort-array-by-parity/

class sort-array-by-parity {
    // tc -> n, sc-> n
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int j=0;
        for(int i=0; i<n; i++){
            if(A[i]%2==0){
                res[j++] = A[i];
            }
        }
        
        for(int i=0; i<n; i++){
            if(A[i]%2!=0)
                res[j++] = A[i];
        }
        
        return res;
    }
    
    // tc -> n, sc-> 1
    public int[] sortArrayByParity(int[] A) {
        for(int i=0, j=0; j<A.length; j++){
            if(A[j]%2==0){
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
