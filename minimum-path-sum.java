// https://leetcode.com/problems/minimum-path-sum/
class minimum-path-sum {
    // tc -> m*n, sc-> 1
    public int minPathSum(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i>0 && j==0){
                   grid[i][j] += grid[i-1][j]; 
                }else if(i==0 && j>0){
                    grid[i][j] += grid[i][j-1];
                }else if(i>0 && j>0){
                    grid[i][j] += Math.min(grid[i-1][j],
                                          grid[i][j-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
