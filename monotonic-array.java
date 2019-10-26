// https://leetcode.com/problems/monotonic-array/
class monotonic-array {
    // tc -> n, sc-> 1
    public boolean isMonotonic(int[] A) {
        return increase(A) || decrease(A);
    }
    
    private boolean increase(int[] A){
        for(int i=1; i<A.length; i++){
            if(A[i-1]>A[i]) return false;
        }
        return true;
    }
    
    private boolean decrease(int[] A){
        for(int i=1; i<A.length; i++){
            if(A[i-1]<A[i]) return false;
        }
        return true;
    }
    // tc -> n, sc-> 1
    public boolean isMonotonic(int[] A) {
        boolean increase = true;
        boolean decrease = true;
        for(int i=1; i<A.length; i++){
            if(A[i-1]>A[i]) increase = false;
            if(A[i-1]<A[i]) decrease = false;
        }        
        return increase || decrease;
    }
}
