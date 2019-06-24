// https://leetcode.com/problems/k-closest-points-to-origin/

class k-closest-points-to-origin {
    // tc -> nlogk, sc -> n
    public int[][] kClosest(int[][] points, int K) {
        List<int[]> res = new ArrayList<>();
        if(points==null || points.length==0) return res.toArray(new int[][]{});
        
         PriorityQueue<int[]> pq = new PriorityQueue<>(
              new Comparator<int[]>(){
                  @Override
                  public int compare(int[] a, int[] b){
                      return getDist(a) - getDist(b);
                  }
              }           
         );   
        
        for(int[] point : points){            
            pq.offer(point);            
        }        
        
        while(!pq.isEmpty() && res.size()<K){
            res.add(pq.poll());
        }
        
        return res.toArray(new int[][]{});
    }
    
    private int getDist(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}
