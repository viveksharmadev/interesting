//https://leetcode.com/problems/unique-paths/
class unique-paths {
    // tc -> m*n, sc-> m*n
    public int uniquePaths(int m, int n) {
        return getUniquePaths(m-1, n-1, new int[m][n]);
    }
    
    private int getUniquePaths(int m, int n, int[][] cache){
        if(m<0 || n<0) return -1;
        if(m==0 || n==0) return 1;
        if(cache[m][n]!=0) return cache[m][n];
        int res = getUniquePaths(m-1, n, cache)
                + getUniquePaths(m, n-1, cache);
        cache[m][n] = res;
        return res;
    }
}
