// https://leetcode.com/problems/fibonacci-number/

class fibonacci-number {
    //tc -> 2^n, sc-> n
    public int fib(int N) {
        if(N<=1) return N;
        return fib(N-1) + fib(N-2);
    }
    
    // tc -> n, sc-> n
    public int fib(int N) {
        return getFib(N, new int[N+1]);
    }
    
    private int getFib(int N, int[] cache){
        if(N<=1) return N;
        if(cache[N]!=0) return cache[N];
        cache[N] = getFib(N-1, cache) + getFib(N-2, cache);
        return cache[N];
    }
    
    // tc -> n, sc-> 1
     public int fib(int N) {
        if(N<=1) return N;
        int a = 0, b = 1;
        
         while(N-- > 1){
             int sum = a+b;
             a = b;
             b = sum;
        }
         return b;
    }
}
