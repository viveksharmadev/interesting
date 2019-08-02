// https://leetcode.com/problems/the-maze-ii/
class the-maze-ii {
 /*
    tc-> m∗n∗max(m,n)
    Complete traversal of maze will be done in the worst case. Here, m and n refers to the number of rows and columns of the maze. Further, for every current node chosen, we can travel upto a maximum depth of max(m,n) in any direction.
    sc-> m*n
    */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for(int[] d : dist)
        Arrays.fill(d, -1);
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        dist[start[0]][start[1]] = 0;
        //boolean[][] visited = new boolean[m][n];
        //visited[start[0]][start[1]] = true;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();                
                for(int[] dir : dirs){                    
                    int x = curr[0];
                    int y = curr[1];
                    int count = dist[x][y];
                    while(isValid(maze, x+dir[0], y+dir[1])){
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                    if(dist[x][y]==-1 || count<dist[x][y]){
                        q.offer(new int[]{x,y});
                        dist[x][y] = count;
                    }
                }
            }            
        }
        return dist[destination[0]][destination[1]];
    }
    
    private boolean isValid(int[][] maze, int x, int y){
        return x>=0 && x<maze.length && y>=0 && y<maze[0].length
            && maze[x][y]!=1;
    }
} 
