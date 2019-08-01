// https://leetcode.com/problems/pour-water/
class pour-water {
    // tc -> n, sc-> 1
    public int[] pourWater(int[] heights, int V, int K) {
        int start = K;
        for(int i=0; i<V; i++){
          while(start>0 && heights[start-1]<=heights[start]){
              start--;
          }  
          
          while(start<heights.length-1 && heights[start]>=heights[start+1]){
                start++;
          }
          
          while(start>K && heights[start]>=heights[start-1]){
                start--;                
          }  
            
          heights[start]++;
            
        }
        return heights;
    }
}
