// https://leetcode.com/problems/cut-off-trees-for-golf-event/

class cut-off-trees-for-golf-event {
    // tc -> m*n, sc-> m*n
    class Forest{
        int x, y, height;
        public Forest(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        
        PriorityQueue<Forest> pq = new PriorityQueue<>(
            new Comparator<Forest>(){
                @Override
                public int compare(Forest a, Forest b){
                    return a.height-b.height;
                }
            }
        );
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(forest.get(i).get(j)>1)
                    pq.offer(new Forest(i,j,forest.get(i).get(j)));
            }
        }
        
        int[] start = {0,0};
        int sum = 0;
        while(!pq.isEmpty()){
            Forest forestObj = pq.poll();
            int[] curr = new int[2];
            curr[0] = forestObj.x;
            curr[1] = forestObj.y;
            int minStep = getMinSteps(start, curr, m, n, forest);
            if(minStep<0) return -1;
            sum += minStep;
            start[0] = curr[0];
            start[1] = curr[1];
        }
        return sum;
    }
    
    private int getMinSteps(int[] start, int[] dest, int m, int n, 
                            List<List<Integer>> forest){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int level = 0;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){            
            int size = q.size();
            for(int i=0; i<size; i++){
            int[] curr = q.poll();
            if(curr[0]==dest[0] && curr[1]==dest[1]) return level;
                for(int[] dir : dirs){                
                    int xx = curr[0] + dir[0];
                    int yy = curr[1] + dir[1];
                    if(xx<0 || xx>m-1 || yy<0 || yy>n-1 
                    || forest.get(xx).get(yy)==0 || visited[xx][yy])
                        continue;                
                    q.offer(new int[]{xx, yy});
                    visited[xx][yy] = true;
                }
            }
            level++;
        }
        return -1;
    }
}
