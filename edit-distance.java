// https://leetcode.com/problems/edit-distance/
class Solution {
    // tc -> mn, sc-> mn
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        
       // if(m*n==0) return m+n; // If one string is empty
        
        int[][] cache = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            cache[i][0] = i;
        }
        
        for(int i=0; i<=n; i++){
            cache[0][i] = i;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1];
                }else{
                    cache[i][j] = Math.min(cache[i][j-1],
                                          Math.min(cache[i-1][j],
                                          cache[i-1][j-1])) + 1;
                }
            }
        }
        return cache[m][n];
    }
}
