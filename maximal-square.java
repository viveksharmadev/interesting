// https://leetcode.com/problems/maximal-square/

class Solution {
    // tc -> mn, sc-> mn
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] cache = new int[rows+1][cols+1];
        
        int maxLen = 0;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                if(matrix[i-1][j-1]=='1')
                cache[i][j] = Math.min(cache[i-1][j-1], 
                                       Math.min(cache[i-1][j], cache[i][j-1]))+1;
                maxLen = Math.max(maxLen, cache[i][j]);
            }
        }
        return maxLen*maxLen;
    }
}
