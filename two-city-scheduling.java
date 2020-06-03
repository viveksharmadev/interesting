// https://leetcode.com/problems/two-city-scheduling/
/*
For every person we have to select either city A or City B for sure.
But the case is we can only send half of the people to A and remaining to B. 
Example we have 100 people we have to send 50 to A and 50 to B. once we sent 50 people to A we have no other option 
but to send remaining to B, and pay the price of B. So the 50 A we selected should be such that the price of B corresponding 
to those A should be as higher than A as possible(ie, B-A should be as high as possible) 
so (Avoiding that B is most beneficial for us ). Hence we are taking difference.
*/
class two-city-scheduling {
    // tc -> nlogn, sc-> n
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, 
                   new Comparator<int[]>(){
                       @Override
                       public int compare(int[] a, int[] b){
                           return (a[0]-a[1])-(b[0]-b[1]);
                       }
                });
        
        int cost = 0;
        for(int i=0; i<costs.length/2; i++){
            cost += costs[i][0] + costs[costs.length-1-i][1];    
        }
        
        return cost;
    }
}
