// https://leetcode.com/problems/search-a-2d-matrix/
class search-a-2d-matrix {
    //tc-> mlogn, sc-> 1
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] m : matrix){
            if(doesExist(m, target)) return true;
        }
        return false;
    }
    
    private boolean doesExist(int[] matrix, int target){
        int start = 0, end = matrix.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(matrix[mid]==target) return true;
            if(target<matrix[mid]) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
    
    //tc-> logmn, sc-> 1
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int m = matrix.length, n = matrix[0].length;
        
        int start = 0, end = m*n-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int pivot = matrix[mid/n][mid%n];
            if(pivot==target){
                return true;
            }
            if(target<pivot)
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }
}
