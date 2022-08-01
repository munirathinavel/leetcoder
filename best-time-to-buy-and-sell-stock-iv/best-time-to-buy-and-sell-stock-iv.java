// Bottom-up 
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        
        for(int i = n-1; i >= 0; i--) {
            for(int transactionRemaining = 1; transactionRemaining <=k; transactionRemaining++) {
                for(int holding =0; holding <2; holding++) {
                    int doNothing = dp[i+1][transactionRemaining][holding];
                    int doSomething;
                    if(holding == 1) {
                        doSomething = prices[i] + dp[i+1][transactionRemaining-1][0];
                    } else {
                        doSomething = - prices[i] + dp[i+1][transactionRemaining][1];
                    }
                    dp[i][transactionRemaining][holding] = Math.max(doSomething, doNothing);
                }
            }
        }
        return dp[0][k][0];
    }
}
// Top-down Recursion
// class Solution {
//     int[] prices;
//     int[][][] memo;
    
//     private int dp(int i, int transactionRemaining, int holding) {
//         // Base Case
//         if(transactionRemaining == 0 || i == prices.length) {
//             return 0;
//         }
        
//         if(memo[i][transactionRemaining][holding] == 0) {
//             int doNothing = dp(i+1, transactionRemaining, holding);
//             int doSomething;
            
//             if(holding == 1 ) {
//                 doSomething = prices[i] + dp(i+1, transactionRemaining -1, 0); 
//             } else {
//                 doSomething = -prices[i] + dp(i+1, transactionRemaining, 1);
//             }
//             memo[i][transactionRemaining][holding] = Math.max(doSomething, doNothing);
//         }
//         return memo[i][transactionRemaining][holding];
//     }
    
//     public int maxProfit(int k, int[] prices) {
//         this.prices = prices;
//         this.memo = new int[prices.length][k + 1][2];
//         return dp(0, k, 0);
//     }
// }