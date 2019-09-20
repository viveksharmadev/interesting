// https://leetcode.com/problems/maximal-rectangle/
class maximal-rectangle {
    // tc -> m*n, sc-> m (length of additional arrays)
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        
        Arrays.fill(right, n);
        
        int maxArea = 0;
        
        for(int i=0; i<m; i++){
            int currLeft = 0, currRight = n;
            // Update Height
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }
            // Update Left
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1')
                    left[j] = Math.max(left[j], currLeft);
                else{ left[j]=0; currLeft=j+1;}                    
            }
            //Update Right
            for(int j=n-1; j>=0; j--){
                if(matrix[i][j]=='1')
                    right[j]=Math.min(right[j], currRight);
                else { right[j]=n; currRight=j;}
            }
            //Update Area
            for(int j=0; j<n; j++){
            maxArea = Math.max(maxArea, (right[j]-left[j])*height[j]);
            }            
        }
        return maxArea;
    }
}
