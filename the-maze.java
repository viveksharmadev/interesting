// https://leetcode.com/problems/the-maze/

class the-maze {
    // tc -> m*n ,sc-> m*n
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1]});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            int size = q.size();            
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                if(x==destination[0] && y==destination[1]) return true;
                for(int[] dir : dirs){
                    int xx = x;
                    int yy = y;
                    while(isValid(xx+dir[0], yy+dir[1], maze)){
                        xx+=dir[0];
                        yy+=dir[1];
                    }
                    if(!visited[xx][yy]){
                    q.offer(new int[]{xx, yy});
                    visited[xx][yy] = true;
                }
                }
                
            }                        
        }
        return false;
    }
    
    private boolean isValid(int x, int y, int[][] maze){
        return x>=0 && x<maze.length && y>=0 && y<maze[0].length 
            && maze[x][y]!=1;
    }
}
