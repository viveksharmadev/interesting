//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv
/* just refer  comments to understand not code
public int maxProfit(int[] prices) {
        //hold[i][j] -  maximum profit at ith day j transactions done and have stock in hand 
        //unhold[i][j] -  maximum profit at ith day j transactions done and  do not have stock in hand
        // unhold exits only after hold & one cycle of buying and selling is a transaction so for simplicity we shall treat a transaction (unhold ) as a selling,( as selling happens only after buying) 
        // whenever we plan on holding(buying) an item it is a loss so we -ve the stock value and append it to our current profit
       
        int n = prices.length;
        if (n <= 1)
		return 0;
        
        int dphold[][] = new int[n][k+1];
        int dpunhold[][] = new int[n][k+1];
        
        
        //base case 1 - only one item and 0 to k transactions, there wont be unhold as we have only one item we can only buy it
        for(int j=0;j<=k;j++)
            dphold[0][j] = -prices[0];
        
    //base case 2 - many items but zero transactions, pick the chepeast of all values ( as we are buyinh so we negate the value)
        for(int i=1;i<n;i++)
            dphold[i][0] = Math.max(dphold[i-1][0],-prices[i]);
        
        // dp intuition - at any point of time you can hold a stock or you might not hold a stock -
        // case 1 - you plan on holding a stock now 
            //sub case (a) you didnt have a stock on hand earlier
            //sub case (b) you did have have a stack on hand earlier
            // pick the best of these 2
        // dphold[i][j] = Max(dpunhold[i-1][j]-prices[i],dphold[i-1][j])
        
        // case 2 - you plan on unholding(selling) a stock now , 
            //sub case (a) you didnt have a stock on hand earlier
            //sub case (b) you did have have a stack on hand earlier
            // pick the best of these 2
        // dpunhold[i][j] = Max(dpunhold[i-1][j],dphold[i-1][j-1]+prices[i])
        
        // finally pick the best of these 2 in the end.
        
        //dp solution
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=k;j++)
            {
                dphold[i][j] = Math.max(dpunhold[i-1][j]-prices[i],dphold[i-1][j]);
                dpunhold[i][j] = Math.max(dpunhold[i-1][j],dphold[i-1][j-1]+prices[i]);
            }
        }
        
        return Math.max(dphold[n-1][k],dpunhold[n-1][k]);
    }
*/
// tc -> m*n, sc-> m*n
public class best-time-to-buy-and-sell-stock-iv {
    //hold[i][k]  ith day k transaction have stock and maximum profit
    //unhold[i][k] ith day k transaction do not have stock at hand and maximum profit
    public int maxProfit(int k, int[] prices) {
        if(k>prices.length/2) return maxP(prices);
        int[][] hold = new int[prices.length][k+1];
        int[][] unhold = new int[prices.length][k+1];
        hold[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++) hold[i][0] = Math.max(hold[i-1][0],-prices[i]);
        for(int j=1;j<=k;j++) hold[0][j] = -prices[0];
        for(int i=1;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                hold[i][j] = Math.max(unhold[i-1][j]-prices[i],hold[i-1][j]);
                unhold[i][j] = Math.max(hold[i-1][j-1]+prices[i],unhold[i-1][j]);
            }
        }
        return Math.max(hold[prices.length-1][k],unhold[prices.length-1][k]);
    }
    public int maxP(int[] prices){
        int res =0;
        for(int i=0;i<prices.length;i++){
            if(i>0 && prices[i] > prices[i-1]){
                res += prices[i]-prices[i-1];
            }
        }
        return res;
    }
}
