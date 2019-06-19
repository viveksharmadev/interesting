// https://leetcode.com/problems/max-points-on-a-line/
class max-points-on-a-line {
    // tc -> n^2, sc-> n
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n<3) return n;
        
        int max = 2;
        for(int i=1; i<points.length; i++){
            int count = 0;
            long x1 = points[i-1][0];
            long y1 = points[i-1][1];
            long x2 = points[i][0];
            long y2 = points[i][1];
            
            if(x1==x2 && y1==y2){
                for(int j=0; j<n; j++){
                    if(points[j][0]==x1 
                       && points[j][1]==y1){
                        count++;
                    }
                }                
            }else{
                for(int j=0; j<n; j++){
                    if((points[j][1]-y2)*(x2-x1)
                      ==(y2-y1)*(points[j][0]-x2)){
                        count++;
                    }
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
