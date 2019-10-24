// https://leetcode.com/problems/walls-and-gates/

class Solution {
    // tc -> m*n, sc-> m*n
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j]==0) q.offer(new int[]{i,j});                
            }
        }
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int currX = curr[0];
                int currY = curr[1];
                for(int[] dir : dirs){
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    if(x<0 || x>rooms.length-1 || y<0 || y>rooms[0].length-1
                      || rooms[x][y]==-1) // Adding rooms[x][y]==-1 is optional
                        continue;
                    if(rooms[x][y]==Integer.MAX_VALUE){
                        rooms[x][y] = rooms[currX][currY]+1;
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
    }
}
