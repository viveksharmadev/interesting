// https://leetcode.com/problems/the-maze/

class the-maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // Ball will not stop -> DFS
        // After hitting the wall, ball can go to any of four directions -> BFS
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==destination[0] && curr[1]==destination[1]) return true;
            for(int[] dir : dirs){
                int x= curr[0];
                int y = curr[1];
                while(isValid(x+dir[0], y+dir[1], maze)){
                    x += dir[0];
                    y += dir[1];
                }
                
                if(!visited[x][y]){
                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                }
            }            
        }
        return false;
    }
    
    private boolean isValid(int x, int y, int[][] maze){
        return x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]!=1;
    }
}
