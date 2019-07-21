// https://leetcode.com/problems/search-a-2d-matrix-ii/
class search-a-2d-matrix-ii {
    // tc -> m+n, sc-> 1
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int row=0, col=matrix[0].length-1;        
        while(col>=0 && row<matrix.length){            
            if(target < matrix[row][col]){
                col--;
            }else if(target > matrix[row][col]){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
}
