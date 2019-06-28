// https://leetcode.com/problems/number-of-distinct-islands/

class number-of-distinct-islands {
    // tc -> m*n, sc-> m*n
    public int numDistinctIslands(int[][] grid) {
        Set<String> visited = new HashSet<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    StringBuilder path = new StringBuilder();
                    makeDistinctPath(grid, path, i, j, "o");
                    visited.add(path.toString());
                }
            }
        }
        return visited.size();
    } 
    
    private void makeDistinctPath(int[][] grid, StringBuilder path, int row, int col, String dir){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1 || grid[row][col]!=1)
            return;
        grid[row][col]=0;
        path.append(dir);
        makeDistinctPath(grid, path, row+1, col, "d");
        makeDistinctPath(grid, path, row-1, col, "u");
        makeDistinctPath(grid, path, row, col+1, "r");
        makeDistinctPath(grid, path, row, col-1, "l");
        path.append("w");
    }
}
